package br.com.fuctura.bibliotecaNoite.controllers.interfaces;

import br.com.fuctura.bibliotecaNoite.dtos.CategoriaDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaController {

    ResponseEntity<CategoriaDto> findById(Integer id);
    ResponseEntity<List<CategoriaDto>> findAll();
    ResponseEntity<CategoriaDto> findByNome(String nome);
    ResponseEntity<CategoriaDto> save(CategoriaDto categoriaDto);
    ResponseEntity<CategoriaDto> update(Integer id, CategoriaDto categoriaDto);
    void delete(Integer id);
}
