package com.luizgomendes.aggregator.controller;

import com.luizgomendes.aggregator.client.DepartmentReactiveClient;
import com.luizgomendes.aggregator.client.UserReactiveClient;
import com.luizgomendes.aggregator.model.Department;
import com.luizgomendes.aggregator.model.DepartmentAggregate;
import com.luizgomendes.aggregator.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/aggregator")
public class AggregatorController {

    private final UserReactiveClient userReactiveClient;
    private final DepartmentReactiveClient departmentReactiveClient;

    public AggregatorController(UserReactiveClient userReactiveClient, DepartmentReactiveClient departmentReactiveClient) {
        this.userReactiveClient = userReactiveClient;
        this.departmentReactiveClient = departmentReactiveClient;
    }

    @GetMapping("/users")
    public Flux<User> getAllUsersWithAge() {
        return userReactiveClient.getAllUsers();
    }

    @GetMapping("/departments")
    public Flux<List<DepartmentAggregate>> getAllDepartments(){
        Flux<Department> departmentFlux = departmentReactiveClient.getAllDepartments();
        List<DepartmentAggregate> listAggregate = new ArrayList<>();
        listAggregate = departmentFlux.flatMap(department -> {
            var userListMono = userReactiveClient.getUsersByDepartment(department.getDepartmentCode()).collectList();
            return userListMono.map(users -> new DepartmentAggregate(department, users));
        }).collectList().block();

        return Flux.just(listAggregate);
    }
    


}
