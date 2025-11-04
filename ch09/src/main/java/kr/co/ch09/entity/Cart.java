package kr.co.ch09.entity;

import jakarta.persistence.*;
import kr.co.ch09.dto.CartDTO;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;
    private String userid;
    private int pno;
    private int quantity;

    public CartDTO toDTO(){
        return CartDTO.builder()
                .cartId(cartId)
                .userid(userid)
                .pno(pno)
                .quantity(quantity)
                .build();
    }

}
