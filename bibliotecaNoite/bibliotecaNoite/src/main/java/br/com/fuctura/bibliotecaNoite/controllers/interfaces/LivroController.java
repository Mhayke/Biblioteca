package br.com.fuctura.bibliotecaNoite.controllers.interfaces;

import br.com.fuctura.bibliotecaNoite.dtos.LivroDto;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface LivroController {

    ResponseEntity<List<LivroDto>> findAll();
    ResponseEntity<LivroDto> findById(@PathVariable Integer id);
    ResponseEntity<LivroDto> findByAutor(String autor);
    ResponseEntity<LivroDto> save(@Valid @RequestBody LivroDto livroDto);
    ResponseEntity<LivroDto> update(@Valid @PathVariable Integer id, @RequestBody LivroDto livroDto);
    ResponseEntity<Void> deleteById(@PathVariable Integer id);
}
