package com.example.API_Tester.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ApiRequest {

    private String url;
    private String method;
    private Map<String,String> headers;
    private String body;
}
