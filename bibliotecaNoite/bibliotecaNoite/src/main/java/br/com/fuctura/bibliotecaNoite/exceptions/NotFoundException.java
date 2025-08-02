package br.com.fuctura.bibliotecaNoite.exceptions;


import java.time.Instant;

public class NotFoundException extends RuntimeException{
    // a classe NotFoundException é uma exceção personalizada que estende RuntimeException
    public NotFoundException(String message) {
        super(message);
    }

}
