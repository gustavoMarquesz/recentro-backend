package com.recentro.recentro.exceptions;

public class ImovelNotFound extends Exception {
    private static final long serialVersionUID = 1L;

    public static  String message = "Id não encontrado:  ";

    public ImovelNotFound() {
        super(message);
    }
}
