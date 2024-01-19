package com.example.api.Controllers;

import com.example.api.requests.EspRequest;
import com.example.api.requests.EspResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class EspController {

    private static final String ESP_ENDPOINT = "http://192.168.0.101:80"; // Replace with your actual endpoint

    public EspResponse sendEspRequest(EspRequest espRequest) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            // Set up the request URL and headers if needed
            // HttpHeaders headers = new HttpHeaders();
            // headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the request entity with the EspRequest object
            // HttpEntity<EspRequest> requestEntity = new HttpEntity<>(espRequest, headers);

            // Send the POST request and receive the response
            ResponseEntity<EspResponse> responseEntity = restTemplate.postForEntity(ESP_ENDPOINT, espRequest, EspResponse.class);

            // Get the response body
            EspResponse espResponse = responseEntity.getBody();
            return espResponse;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Handle HTTP errors (4xx and 5xx status codes)
            System.err.println("HTTP Error: " + e.getRawStatusCode() + " - " + e.getResponseBodyAsString());
            // You can throw a custom exception or return an error response if needed.
        } catch (ResourceAccessException e) {
            // Handle general connectivity issues (timeout, network unreachable, etc.)
            System.err.println("Connection Error: " + e.getMessage());
            // You can throw a custom exception or return an error response if needed.
        }

        return null;
    }

}
