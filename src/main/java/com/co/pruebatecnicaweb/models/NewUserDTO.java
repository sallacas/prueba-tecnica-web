package com.co.pruebatecnicaweb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class NewUserDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
