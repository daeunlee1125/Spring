package kr.co.ch09.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // jwt 토큰 + request 같이 보내겠죵
    // security보다도 앞단에 json 필터 위치함!
    // JwtAuthenticationFilter -> MyUserDetails -> UserController?

    private final JwtProvider jwtProvider;
    private final String AUTH_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 토큰 추출
        String header = request.getHeader(AUTH_HEADER);
        log.info("header: {}", header);

        if (header == null) {
            // 인증된 사용자 아니면 시큐리티 인증처리 없이 그냥 넘어감
            log.info("header is null");
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.substring(TOKEN_PREFIX.length()).trim();

        // 토큰 검사
        try {
            jwtProvider.validateToken(token);
            log.info("token validated");
            
            // 시큐리티 인증처리
            Authentication authentication = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            

        } catch (Exception e) {
            log.info("token validation failed");
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }


        filterChain.doFilter(request, response); // 다음 필터(security)로 요청 넘겨줌
    }

}
