package br.com.fuctura.bibliotecaNoite.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    // a classe DataIntegrityViolationException é uma exceção personalizada que estende RuntimeException
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
