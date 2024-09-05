package com.co.pruebatecnicaweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PracticeFormDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private String subject;
    private String hobbies;
    private String currentAddress;
    private String state;
    private String city;
}
