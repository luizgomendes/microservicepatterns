package com.luizgomendes.aggregator.client;

import com.luizgomendes.aggregator.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class DepartmentReactiveClient {

    private final WebClient webClient;

    @Value("${client.department-reactive-service}")
    private String departmentServiceUrl;

    @Autowired
    public DepartmentReactiveClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Department> getAllDepartments() {
        String url = departmentServiceUrl.concat("/list");
        return webClient.get().uri(url).retrieve().bodyToFlux(Department.class).log();
    }
}
