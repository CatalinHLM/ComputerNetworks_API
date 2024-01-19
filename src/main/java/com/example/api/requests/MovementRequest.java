package com.example.api.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovementRequest {
    private Double speed;
    private Integer right;
    private Integer front;
    private Integer left;
    private Integer back;
}
