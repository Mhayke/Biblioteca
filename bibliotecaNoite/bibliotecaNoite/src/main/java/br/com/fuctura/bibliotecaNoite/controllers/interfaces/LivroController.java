package br.com.fuctura.bibliotecaNoite.controllers.interfaces;

import br.com.fuctura.bibliotecaNoite.dtos.LivroDto;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LivroController {

    ResponseEntity<List<LivroDto>> findAll();
    ResponseEntity<LivroDto> findById(Integer id);
    ResponseEntity<LivroDto> findByAutor(String autor);
    ResponseEntity<LivroDto> save(LivroDto livroDto);
    ResponseEntity<LivroDto> update(LivroDto livroDto);
    ResponseEntity<Void> deleteById(@PathVariable Integer id);
}
