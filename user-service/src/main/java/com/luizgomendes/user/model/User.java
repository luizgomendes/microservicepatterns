package com.luizgomendes.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;



@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @NotNull(message = "Name is mandatory")
    private String name;
    private String departmentId;
    @NotNull(message = "Hiring date is mandatory")
    private LocalDate hiringDate;
    @NotNull(message = "Birthday is mandatory")
    @Past(message = "Birthday must be in the past")
    private LocalDate birthday;
    private double salary;
}
