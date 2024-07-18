package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Value("${python.api.url}")
    private String pythonApiUrl;

    private final RestTemplate restTemplate;

    public DeviceController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/predict")
    public Map<String, List<Integer>> predictDevicePrice(@RequestBody List<Map<String, Object>> deviceData) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<List<Map<String, Object>>> requestEntity = new HttpEntity<>(deviceData, headers);

        ResponseEntity<Map<String, List<Integer>>> response = restTemplate.exchange(
                pythonApiUrl + "/predict",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<Map<String, List<Integer>>>() {}
        );

        return response.getBody();
    }
}
