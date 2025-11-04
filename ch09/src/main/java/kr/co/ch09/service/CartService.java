package kr.co.ch09.service;

import kr.co.ch09.dto.CartDTO;
import kr.co.ch09.entity.Cart;
import kr.co.ch09.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;

    public CartDTO save(CartDTO dto){
        Cart savedCart = cartRepository.save(dto.toEntity());
        return savedCart.toDTO();
    }

    public List<CartDTO> findByUserid(String userid){
        List<Cart> cartList = cartRepository.findByUserid(userid);

        return cartList.stream()
                .map(Cart::toDTO)
                .toList();
    }

}
