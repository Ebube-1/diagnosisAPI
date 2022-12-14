package com.example.medicalDiagnosisApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Specialization extends ApiMedicEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long specialistId;
}
