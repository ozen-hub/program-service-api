package com.devstack.lms.programserviceapi.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProgramAspectsServiceImpl {

    private final WebClient webClient;

    int count;
    @CircuitBreaker(name="subjectService", fallbackMethod = "fallbackMethod")
    public Boolean checkSubjects(String ids){
        System.out.println("count : "+count++);
        return webClient.get().uri("http://localhost:9090/api/v1/subjects/{id}",ids)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }

    public Boolean fallbackMethod(String ids, Exception e){
        System.out.println("Failed");
        System.out.println("Count : "+count);
        return false;
    }
}
