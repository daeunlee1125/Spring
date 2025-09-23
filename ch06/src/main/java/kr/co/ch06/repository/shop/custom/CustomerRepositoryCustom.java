package kr.co.ch06.repository.shop.custom;

import kr.co.ch06.entity.shop.Customer;

import java.util.List;

// QueryDSL을 사용하기 위한 CustomerRepository의 확장 인터페이스
public interface CustomerRepositoryCustom {

    public Customer selectCustomer(String custId);
    public List<Customer> selectAllCustomer();
    public List<Customer> selectProjectionCustomer();
    // insert update delete는 queryDSL 쓸 필요 X
    // 그냥 jpa 기본 메서드 쓰면 됨... save 같은 거
}
