package kr.co.ch02.sub3;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect // 관심사
@Component
public class Advice { // Advice : 관심사(부가기능)을 정의해 놓은 모듈

    // 포인트컷 : 핵심 기능에 삽입하는, 내용 없는 참조 메서드
    @Pointcut("execution(void kr.co.ch02.sub3.Service.register())")
    public void insert(){}

    @Pointcut("execution(void kr.co.ch02.sub3.Service.findById())")
    public void select(){}

    // 포인트컷에 등록된 서비스의 모든 기능 실행 직전에 before 메서드 실행
    @Before("insert() || select()")
    public void before()
    {
        System.out.println("before...");
    }

    @After("insert() || select()")
    public void after()
    {
        System.out.println("after...");
    }

    @Around("select()") // pjp는 핵심 기능
    public void around(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("around before...");

        // 핵심 기능 실행
        pjp.proceed();

        System.out.println("around after...");
    }

}
