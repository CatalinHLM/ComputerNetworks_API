package com.example.api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspResponse {
    private Integer farLeft;
    private Integer left;
    private Integer center;
    private Integer right;
    private Integer farRight;
    private Double lineLeft;
    private Double lineRight;
    private Double leftWheelSpeed;
    private Double rightWheelSpeed;
}
