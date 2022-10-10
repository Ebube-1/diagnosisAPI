package com.example.medicalDiagnosisApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Issue extends ApiMedicEntity {

    private String name;

    private long accuracy;

    private String Icd;

    private String icdName;

    private String profName;

    private int ranking;

}

