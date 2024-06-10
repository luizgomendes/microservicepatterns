package com.luizgomendes.department.repository;

import com.luizgomendes.department.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, String> {
    public List<Department> findByDepartmentCode(String departmentCode);
}
