package com.example.API_Tester.repository;

import com.example.API_Tester.entity.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog,Long> {

}
