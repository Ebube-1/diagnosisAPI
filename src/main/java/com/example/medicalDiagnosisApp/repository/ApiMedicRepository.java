package com.example.medicalDiagnosisApp.repository;

import com.example.medicalDiagnosisApp.entity.ApiMedicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ApiMedicRepository<TEntity extends ApiMedicEntity> extends JpaRepository<TEntity, Long> {

    List<TEntity> findAllByApiMedicIdIn(Collection<Long> apiMedicIds);

    TEntity findByApiMedicId(long apiMedicId);
}
