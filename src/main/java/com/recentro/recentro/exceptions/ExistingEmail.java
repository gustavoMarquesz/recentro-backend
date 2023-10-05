package com.recentro.recentro.exceptions;

public class ExistingEmail extends Exception {
    private static final long serialVersionUDI = 1L;

    public static  String message = "Email em uso";

    public ExistingEmail(){
        super(message);
    }
}