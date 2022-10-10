package com.example.medicalDiagnosisApp.repository;

import com.example.medicalDiagnosisApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query( value = "SELECT * FROM patient p WHERE lower(email) = lower(:email)",
            nativeQuery = true)
    Patient getPatientByEmail (String email);


}

