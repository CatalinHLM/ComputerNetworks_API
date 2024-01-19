package com.example.api.Controllers;

import com.example.api.requests.MovementRequest;
import com.example.api.requests.MovementResponse;
import com.example.api.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iot/")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping("/move")
    public ResponseEntity<MovementResponse> processJson(@RequestBody MovementRequest request) {
        // Process the received JSON and create a response
        String message = "Movement Received";

        // Return the response with a 200 OK status
        return new ResponseEntity<MovementResponse>(movementService.move(request), HttpStatus.OK);
    }

    @PostMapping("/movement")
    public ResponseEntity<String> setMovement(@RequestBody MovementRequest request) {
        // Process the received JSON and create a response
        String message = "Received JSON: " + request.toString();

        // Return the response with a 200 OK status
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}