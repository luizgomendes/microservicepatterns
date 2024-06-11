package com.luizgomendes.department.controller;

import com.luizgomendes.department.model.Department;
import com.luizgomendes.department.service.DepartmentReactiveService;
import com.luizgomendes.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequestMapping("/department/reactive")
@RestController
public class DepartmentReactiveController {
    private final DepartmentReactiveService departmentService;

    @Autowired
    public DepartmentReactiveController(DepartmentReactiveService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public Flux<Department> findAllDepartments() {
        return departmentService.findAllDepartments();
    }

}
