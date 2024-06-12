package com.luizgomendes.aggregator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    private String id;
    private String departmentCode;
    private String departmentName;
    private List<User> users;
}
