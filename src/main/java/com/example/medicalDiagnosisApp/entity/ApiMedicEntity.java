package com.example.medicalDiagnosisApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class ApiMedicEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private Long apiMedicId;
}
