package com.example.medicalDiagnosisApp.exception;

public class ClientRequestException extends RuntimeException{
    public ClientRequestException(String message){
        super(message);
    }
}
