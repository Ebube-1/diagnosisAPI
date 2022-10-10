package com.example.medicalDiagnosisApp.service;

import com.example.medicalDiagnosisApp.dto.request.DiagnosisDto;
import com.example.medicalDiagnosisApp.dto.request.LoginDto;
import com.example.medicalDiagnosisApp.dto.request.PatientDto;
import com.example.medicalDiagnosisApp.dto.request.SymptomsDto;
import com.example.medicalDiagnosisApp.dto.response.DiagnosisResult;
import org.springframework.http.ResponseEntity;

public interface PatientService {

     ResponseEntity<String> registerPatient(PatientDto patientDto);

     ResponseEntity<String> patientLogin(LoginDto loginDto);
     ResponseEntity<String> saveOrUpdateSymptom(SymptomsDto symptomsDto);

     ResponseEntity<String> inputSymptom(Long id, SymptomsDto symptomsDto);
     DiagnosisResult getDiagnosis(Long id, DiagnosisDto diagnosisDto);
}
