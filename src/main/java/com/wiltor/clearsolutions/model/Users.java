package com.wiltor.clearsolutions.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;


@Data
@AllArgsConstructor
@Builder
public class Users {

    @Valid

    @NotNull
  
    @Pattern(regexp = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")
    private String email;

    @NotNull
   
    private String name;

    @NotNull
   
    private String lastname;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String adress;
    private String phone;



    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

}
