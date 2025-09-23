package kr.co.ch06.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductAggDTO {

    private int priceSum;
    private double priceAvg;
    private int priceMin;
    private int priceMax;

}
