package com.luizgomendes.aggregator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    private String name;
    private String departmentId;
    private LocalDate hiringDate;
    private LocalDate birthday;
    private Long age;
    private Double salary;
}
