package com.example.medicalDiagnosisApp.repository;

import com.example.medicalDiagnosisApp.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends ApiMedicRepository<Symptom> {

    @Query(value = "SELECT * FROM symptom WHERE patient_id = :id",
            nativeQuery = true)
    Symptom findSymptomByPatientId(Long id);


}
