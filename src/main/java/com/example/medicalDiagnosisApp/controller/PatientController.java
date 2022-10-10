package com.example.medicalDiagnosisApp.controller;

import com.example.medicalDiagnosisApp.dto.request.DiagnosisDto;
import com.example.medicalDiagnosisApp.dto.request.PatientDto;
import com.example.medicalDiagnosisApp.dto.request.SymptomsDto;
import com.example.medicalDiagnosisApp.dto.response.DiagnosisResult;
import com.example.medicalDiagnosisApp.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<String> savePatient(@RequestBody PatientDto patientDto){
        return patientService.registerPatient(patientDto);
    }

    @PostMapping("/symptoms/{id}")
    public ResponseEntity<String> saveSymptom(@PathVariable Long id, @RequestBody SymptomsDto symptomsDto){
        return patientService.inputSymptom(id, symptomsDto);
    }

    @GetMapping("/symptoms/{id}")
    public DiagnosisResult getDiagnosis (@PathVariable Long id, @RequestBody DiagnosisDto diagnosisDto){
        return patientService.getDiagnosis(id, diagnosisDto);
    }
}
