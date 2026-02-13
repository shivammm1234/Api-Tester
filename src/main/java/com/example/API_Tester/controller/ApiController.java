package com.example.API_Tester.controller;

import com.example.API_Tester.dto.ApiRequest;
import com.example.API_Tester.dto.ApiResponse;
import com.example.API_Tester.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ApiController {
    @Autowired
    private ApiService service;

    @PostMapping("/execute")
    public ApiResponse execute(@RequestBody ApiRequest request){

        return service.execute(request);
    }
}
