package com.example.sercuritytodo.handling;

public class ApiException extends RuntimeException{
    public ApiException(String msg){
        super(msg);
    }
}
