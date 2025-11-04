package kr.co.ch09.dto;

import kr.co.ch09.entity.Cart;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private int cartId;
    private String userid;
    private int pno;
    private int quantity;

    public Cart toEntity(){
        return Cart.builder()
                .cartId(cartId)
                .userid(userid)
                .pno(pno)
                .quantity(quantity)
                .build();
    }
}
