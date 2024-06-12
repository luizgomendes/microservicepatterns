package com.luizgomendes.user.service;

import com.luizgomendes.user.model.User;
import com.luizgomendes.user.repository.UserReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UserReactiveService {
    private UserReactiveRepository userReactiveRepository;

    @Autowired
    public UserReactiveService(UserReactiveRepository userReactiveRepository) {
        this.userReactiveRepository = userReactiveRepository;
    }

    public Flux<User> listAllUsers() {
        return userReactiveRepository.findAll();
    }
    public Flux<User> listUsersByDepartmentCode(String departmentCode) {
        return userReactiveRepository.findByDepartmentId(departmentCode);
    }
}
