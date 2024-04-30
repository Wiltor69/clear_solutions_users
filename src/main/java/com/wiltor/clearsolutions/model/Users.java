package com.wiltor.clearsolutions.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Users {

    @Valid

    @NotNull(message = "Please write email")
    @NotBlank(message = "Please write email")
    @Pattern(regexp = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")
    private String email;

    @NotNull(message = "Please write name")
    @NotBlank(message = "Please write name")
    private String name;

    @NotNull(message = "Please write last name")
    @NotBlank(message = "Please write last name")
    private String lastname;

    @NotNull(message = "Please write date birthday")
    @NotBlank(message = "Please write date birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    private String adress;
    private String phone;



}
