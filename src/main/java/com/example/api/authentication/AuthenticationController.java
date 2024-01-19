package com.example.api.authentication;
import org.json.JSONException;
import org.json.JSONObject;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/api/auth/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ){
        return ResponseEntity.ok(service.login(request));
    }

    @GetMapping("api/checkToken")
    public ResponseEntity<String> checkToken() throws JSONException {
        JSONObject message = new JSONObject();
        message.put("message", true);
        String stringMessage = message.toString();

        return ResponseEntity.ok(stringMessage);
    }
}
