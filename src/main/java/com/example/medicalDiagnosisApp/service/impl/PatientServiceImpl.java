package com.example.medicalDiagnosisApp.service.impl;

import com.example.medicalDiagnosisApp.dto.request.DiagnosisDto;
import com.example.medicalDiagnosisApp.dto.request.LoginDto;
import com.example.medicalDiagnosisApp.dto.request.PatientDto;
import com.example.medicalDiagnosisApp.dto.request.SymptomsDto;
import com.example.medicalDiagnosisApp.dto.response.DiagnosisResult;
import com.example.medicalDiagnosisApp.entity.Patient;
import com.example.medicalDiagnosisApp.entity.Symptom;
import com.example.medicalDiagnosisApp.exception.ClientRequestException;
import com.example.medicalDiagnosisApp.repository.DiagnosisRepository;
import com.example.medicalDiagnosisApp.repository.PatientRepository;
import com.example.medicalDiagnosisApp.repository.SymptomRepository;
import com.example.medicalDiagnosisApp.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Null;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final SymptomRepository symptomRepository;

    private final DiagnosisRepository diagnosisRepository;

    private final RestTemplate restTemplate;

    @Value("${external.api.url.get.diagnosis}")
    private String externalUrlForGetDiagnosis;

    public ResponseEntity<String> registerPatient(PatientDto patientDto){
        Patient patientByEmail = patientRepository.getPatientByEmail(patientDto.getEmail());
        if(patientByEmail != null){
            return new ResponseEntity<>("Patient with this email already exists", HttpStatus.NOT_FOUND);
        }
        Patient patient = new Patient();
        patient.setAge(patientDto.getAge());
        patient.setEmail(patientDto.getEmail());
        patient.setFirstName(patient.getFirstName());
        patient.setGender(patient.getGender());
        patient.setLastName(patient.getLastName());
        patient.setPassword(patient.getPassword());
        patientRepository.save(patient);
        return new ResponseEntity<>("Patient saved", HttpStatus.OK);
    }


    public ResponseEntity<String> patientLogin(LoginDto loginDto){


        return null;
    }







    public ResponseEntity<String> saveOrUpdateSymptom(SymptomsDto symptomsDto){

        return null;
    }

    public ResponseEntity<String> inputSymptom(Long id, SymptomsDto symptomsDto){
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ClientRequestException("Kindly register as a patient"));
        Symptom symptom = Symptom.builder()
                .patient(patient)
                .description(symptomsDto.getName())
                .build();
        symptomRepository.save(symptom);
        return new ResponseEntity<>("Symptom inputted", HttpStatus.OK);
    }




    @Transactional
    public DiagnosisResult getDiagnosis(Long id, DiagnosisDto diagnosisDto){
        ResponseEntity<DiagnosisResult[]> restTemplateForEntity =
                restTemplate.getForEntity(externalUrlForGetDiagnosis, DiagnosisResult[].class, HttpStatus.OK);
        System.out.println(restTemplateForEntity);
        return null;
    }

//    public ResponseEntity<DiagnosisResult> getDiagnosis(Long id, SymptomsDto symptomsDto){
//
//    }


    //Allow users to enter a patient’s symptoms and return diagnosis results.
}
