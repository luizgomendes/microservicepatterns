package com.luizgomendes.user.repository;

import com.luizgomendes.user.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserReactiveRepository extends ReactiveMongoRepository<User, String> {
    Flux<User> findByDepartmentId(String departmentId);

}