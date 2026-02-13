package com.example.API_Tester.service;

import com.example.API_Tester.dto.ApiRequest;
import com.example.API_Tester.dto.ApiResponse;
import com.example.API_Tester.entity.RequestLog;
import com.example.API_Tester.repository.RequestLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;



import java.util.HashMap;
import java.util.Map;

@Service

public class ApiService {

    @Autowired
    private  RequestLogRepository repo;
    @Autowired
    private RestTemplate restTemplate ;

    public ApiResponse execute(ApiRequest request) {

        try {

            HttpHeaders headers = new HttpHeaders();
            if (request.getHeaders() != null){
                request.getHeaders().forEach(headers::set);
            }

            HttpEntity<String> entity =
                    new HttpEntity<>(request.getBody(), headers);

            long start = System.currentTimeMillis();

            ResponseEntity<String> response =
                    restTemplate.exchange(
                            request.getUrl(),
                            HttpMethod.valueOf(request.getMethod()),
                            entity,
                            String.class
                    );

            long time = System.currentTimeMillis() - start;

            Map<String,String> headerMap = new HashMap<>();
            response.getHeaders().forEach((k,v)->headerMap.put(k, String.join(",", v)));

            repo.save(RequestLog.builder()
                    .url(request.getUrl())
                    .method(request.getMethod())
                    .headers(String.valueOf(request.getHeaders()))
                    .body(request.getBody())
                    .status(response.getStatusCode().value())
                    .responseTime(time)
                    .build());

            return ApiResponse.builder()
                    .status(response.getStatusCode().value())
                    .body(response.getBody())
                    .headers(headerMap)
                    .time(time)
                    .build();

        } catch (Exception e) {

            return ApiResponse.builder()
                    .status(500)
                    .body(e.getMessage())
                    .headers(new HashMap<>())
                    .time(0)
                    .build();
        }
    }

}
