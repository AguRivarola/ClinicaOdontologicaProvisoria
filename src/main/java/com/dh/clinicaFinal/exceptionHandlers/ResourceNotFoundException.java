package com.dh.clinicaFinal.exceptionHandlers;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }

}
