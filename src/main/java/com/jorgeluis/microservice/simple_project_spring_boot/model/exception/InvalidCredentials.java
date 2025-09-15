package com.jorgeluis.microservice.simple_project_spring_boot.model.exception;

public class InvalidCredentials extends Exception {
    public InvalidCredentials(String message) {
        super(message);
    }
    public InvalidCredentials() {
        super("Verifier again the credentials of the form before try again");
    }

}
