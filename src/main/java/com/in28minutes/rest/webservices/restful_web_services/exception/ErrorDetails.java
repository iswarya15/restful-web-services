package com.in28minutes.rest.webservices.restful_web_services.exception;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDate timestamp,String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
