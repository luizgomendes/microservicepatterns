package com.luizgomendes.aggregator.client;


import ch.qos.logback.core.net.server.Client;
import com.luizgomendes.aggregator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class UserReactiveClient {

    private final WebClient webClient;

    @Value("${client.user-reactive-service}")
    private String userServiceUrl;

    @Autowired
    public UserReactiveClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<User> getAllUsers() {
        var url = userServiceUrl.concat("/list");
        return webClient.get().uri(url).retrieve().bodyToFlux(User.class).doOnEach(u->{
            if(u.get()!=null && u.get().getBirthday()!= null) {
              u.get().setAge(ChronoUnit.YEARS.between(u.get().getBirthday(), LocalDate.now()));
            }
        }).log();
    }

    public Flux<User> getUsersByDepartment(String departmentCode) {
        var url = userServiceUrl.concat("/list/"+departmentCode);
        return webClient.get().uri(url).retrieve().bodyToFlux(User.class).doOnEach(u->{
            if(u.get()!=null && u.get().getBirthday()!= null) {
                u.get().setAge(ChronoUnit.YEARS.between(u.get().getBirthday(), LocalDate.now()));
            }
        }).log();
    }


}
