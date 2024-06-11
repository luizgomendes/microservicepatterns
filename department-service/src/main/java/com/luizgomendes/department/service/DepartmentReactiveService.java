package com.luizgomendes.department.service;

import com.luizgomendes.department.model.Department;
import com.luizgomendes.department.repository.DepartmentReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DepartmentReactiveService {

    private final DepartmentReactiveRepository departmentReactiveRepository;

    @Autowired
    public DepartmentReactiveService(DepartmentReactiveRepository departmentReactiveRepository) {
        this.departmentReactiveRepository = departmentReactiveRepository;
    }

    public Flux<Department> findAllDepartments() {
        return departmentReactiveRepository.findAll();
    }

    public Mono<Department> findByDepartmentCode(String departmentCode) {
        return departmentReactiveRepository.findByDepartmentCode(departmentCode);
    }


}
