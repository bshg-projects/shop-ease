package org.bshg.shopease.zutils.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ApiError {
    private String message;
    private HttpStatus status;
    private int statusCode;
    private final Timestamp timestamp;

    public ApiError() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public ApiError(String message, HttpStatus status) {
        this();
        this.message = message;
        this.status = status;
    }

    public String getMessage() {return message;}
    public void setMessage(String message) {this.message = message;}
    public int getStatusCode() {return statusCode;}
    public HttpStatus getStatus() {return status;}
    public Timestamp getTimestamp() {return timestamp;}
    public void setStatus(HttpStatus status) {
    this.status = status;
    this.statusCode = this.status.value();
    }
}
