package com.example.medicalDiagnosisApp.dto.response;

import com.example.medicalDiagnosisApp.entity.Issue;
import com.example.medicalDiagnosisApp.entity.Specialization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisResult {

    private Issue issues;
    private List<Specialization> doctor;

}
