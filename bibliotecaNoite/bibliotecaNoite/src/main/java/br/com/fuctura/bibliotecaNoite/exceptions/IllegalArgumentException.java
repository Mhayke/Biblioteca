package br.com.fuctura.bibliotecaNoite.exceptions;

public class IllegalArgumentException extends RuntimeException{
    // a classe IllegalArgumentException é uma exceção personalizada que estende RuntimeException
    public IllegalArgumentException(String message) {
        super(message);
    }
}
