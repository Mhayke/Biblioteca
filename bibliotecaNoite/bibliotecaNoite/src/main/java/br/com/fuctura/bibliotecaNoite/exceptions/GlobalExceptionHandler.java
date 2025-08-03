package br.com.fuctura.bibliotecaNoite.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice // Anotação que indica que esta classe é um manipulador global de exceções
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Aqui você pode adicionar métodos para tratar exceções específicas

    @ExceptionHandler(NotFoundException.class) // Anotação que indica que este método irá tratar exceções do tipo NotFoundException
    public ResponseEntity<StandardError> notFoundException(NotFoundException e, HttpServletRequest request) {
        StandardError error = new StandardError( // Criação de um objeto StandardError para encapsular os detalhes do erro
                LocalDateTime.now(), // Data e hora atual do erro timestamp
                HttpStatus.NOT_FOUND.value(), // Código de status HTTP (404 Not Found)
                e.getMessage(), // Mensagem de erro personalizada da exceção
                request.getRequestURI()); // URI da requisição que causou o erro
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); // Retorna uma resposta com o status 404 (Not Found) e o corpo contendo os detalhes do erro
    }

    @ExceptionHandler(IllegalArgumentException.class) // Anotação que indica que este método irá tratar exceções do tipo IllegalArgumentException
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        StandardError error = new StandardError( // Criação de um objeto StandardError para encapsular os detalhes do erro
                LocalDateTime.now(), // Data e hora atual do erro timestamp
                HttpStatus.BAD_REQUEST.value(), // Código de status HTTP (400 Bad Request)
                e.getMessage(), // Mensagem de erro personalizada da exceção
                request.getRequestURI()); // URI da requisição que causou o erro
        return ResponseEntity.badRequest().body(error); // Retorna uma resposta com o status 404 (Not Found) e o corpo contendo os detalhes do erro
    }

    @ExceptionHandler(DataIntegrityViolationException.class) // Anotação que indica que este método irá tratar exceções do tipo DataIntegrityViolationException
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        StandardError error = new StandardError( // Criação de um objeto StandardError para encapsular os detalhes do erro
                LocalDateTime.now(), // Data e hora atual do erro timestamp
                HttpStatus.CONFLICT.value(), // Código de status HTTP (409 Conflict)
                e.getMessage(), // Mensagem de erro personalizada da exceção
                request.getRequestURI()); // URI da requisição que causou o erro
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error); // Retorna uma resposta com o status 404 (Not Found) e o corpo contendo os detalhes do erro
    }

}
