package com.luizgomendes.department.repository;

import com.luizgomendes.department.model.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DepartmentReactiveRepository extends ReactiveMongoRepository<Department, String> {
    Mono<Department> findByDepartmentCode(String departmentCode);
}
