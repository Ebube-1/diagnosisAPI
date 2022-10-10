package com.example.medicalDiagnosisApp.repository;

import com.example.medicalDiagnosisApp.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
}
