package com.example.api.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EspRequest {
    private double leftWheelSpeed;
    private double rightWheelSpeed;
}
