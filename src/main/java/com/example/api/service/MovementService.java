package com.example.api.service;

import com.example.api.Controllers.EspController;
import com.example.api.Controllers.EspSerializedController;
import com.example.api.requests.EspRequest;
import com.example.api.requests.EspResponse;
import com.example.api.requests.MovementRequest;
import com.example.api.requests.MovementResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final EspSerializedController espController;

    public MovementResponse move(MovementRequest movementRequest) {

        double leftWheelSpeed = 0;
        double rightWheelSpeed = 0;
        double speed = movementRequest.getSpeed();

        if (movementRequest.getFront() == 1) {
            leftWheelSpeed = 1 * speed / 100;
            rightWheelSpeed = 1 * speed / 100;
        } else if (movementRequest.getBack() == 1) {
            leftWheelSpeed = -1 * speed / 100;
            rightWheelSpeed = -1 * speed / 100;
        } else if (movementRequest.getLeft() == 1) {
            leftWheelSpeed = -1 * speed / 100;
            rightWheelSpeed = 1 * speed / 100;
        } else if (movementRequest.getRight() == 1) {
            leftWheelSpeed = 1 * speed / 100;
            rightWheelSpeed = -1 * speed / 100;
        }
        EspResponse espResponse = espController.sendEspRequest(EspRequest.builder()
                .leftWheelSpeed(leftWheelSpeed)
                .rightWheelSpeed(rightWheelSpeed)
                .build());

        if(espResponse != null)
            return MovementResponse.builder().farLeft(espResponse.getFarLeft())
                    .left(espResponse.getLeft())
                    .center(espResponse.getCenter())
                    .right(espResponse.getRight())
                    .farRight(espResponse.getFarRight())
                    .lineLeft(espResponse.getLineLeft())
                    .lineRight(espResponse.getLineRight())
                    .leftWheelSpeed(espResponse.getLeftWheelSpeed())
                    .rightWheelSpeed(espResponse.getRightWheelSpeed())
                    .build();
        else
            return MovementResponse.builder().message("Connection with the ESP32 failed").build();
    }
}
