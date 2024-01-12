package com.example.api.Controllers;

import com.example.api.authentication.AuthenticationResponse;
import com.example.api.authentication.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/iot")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> demonstration(){
        return ResponseEntity.ok("this is a demo");
    }
}
