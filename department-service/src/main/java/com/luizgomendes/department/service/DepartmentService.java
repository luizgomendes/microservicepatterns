package com.luizgomendes.department.service;

import com.luizgomendes.department.model.Department;
import com.luizgomendes.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Iterable<Department> findAllDepartments() {
        return this.departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findById(String id) {
        return departmentRepository.findById(id);
    }

    public Optional<Department> findByCode(String code) {
        List<Department> departmentList = departmentRepository.findByDepartmentCode(code);
        if(departmentList == null || departmentList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(departmentList.get(0));
        }
    }
}
