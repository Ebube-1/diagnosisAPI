package com.example.medicalDiagnosisApp.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    @NotBlank(message = "The field firstname must not be empty")
    private String firstName;

    @NotBlank(message = "The field email must not be empty")
    @Email(message = "Email is invalid")
    private String email;

    private String password;

    @NotBlank(message = "The field lastname must not be empty")
    private String lastName;

    @Min(value = 0, message = "age must be above 0")
    private int age;

    @NotBlank(message = "The field gender must not be empty")
    private String gender;
}
