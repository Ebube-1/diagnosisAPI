package com.example.medicalDiagnosisApp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Symptom extends ApiMedicEntity {

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Patient patient;
}
