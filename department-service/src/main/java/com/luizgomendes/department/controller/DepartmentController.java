package com.luizgomendes.department.controller;

import com.luizgomendes.department.model.Department;
import com.luizgomendes.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public Iterable<Department> getAllDepartments() {
        return departmentService.findAllDepartments();
    }

    @PostMapping("/save")
    public void saveDepartment(@RequestBody @Valid Department department) {
        if(department.getId() != null && department.getId().isEmpty()) {
            department.setId(null);
        }

        departmentService.saveDepartment(department);
    }
}
