package com.example.medicalDiagnosisApp.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Diagnosis extends BaseEntity {

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Issue issue;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Specialization> specializations;

    @ManyToOne
    private Symptom symptom;
}
