package com.luizgomendes.user.service;

import com.luizgomendes.user.model.Department;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DepartmentService {

    private final WebClient webClient;

    public DepartmentService() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8080/department").build();
    }

    public List<Department> getDepartmentList() {
        Mono<List<Department>> responseMono =  webClient.get().uri("/list").retrieve().bodyToMono(new ParameterizedTypeReference<List<Department>>() {
        });
        return responseMono.block();
    }
}
