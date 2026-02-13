package com.example.API_Tester.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestLog {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String url;
//    private String method;
//
//    @Column(columnDefinition = "TEXT")
//    private String headers;
//
//    @Column(columnDefinition = "TEXT")
//    private String body;
//
//    private int status;
//    private long responseTime;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String method;

    @Column(length = 5000)
    private String headers;

    @Column(length = 10000)
    private String body;

    private int status;
    private long responseTime;
}
