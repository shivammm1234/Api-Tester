package com.example.API_Tester.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ApiResponse {

    private int status;
    private String body;
    private Map<String, String> headers;
    private long time;

}
