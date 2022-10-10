package com.example.medicalDiagnosisApp.exception;

public class ServerException extends RuntimeException{
    public ServerException(String message){
        super(message);
    }
}
