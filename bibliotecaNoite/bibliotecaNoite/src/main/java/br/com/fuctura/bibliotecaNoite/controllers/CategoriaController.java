package br.com.fuctura.bibliotecaNoite.controllers;

import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    //@GetMapping("/{id}") = // Método para buscar uma categoria pelo ID
    //@GetMapping = // Método para listar todas as categorias
    //@PostMapping = // Método para criar uma nova categoria
    //@PutMapping("/{id}") = // Método para atualizar uma categoria existente
    // @DeleteMapping("/{id}") = // Método para deletar uma categoria pelo ID

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return cat;
    }

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaService.findAll();
        return list;
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        Categoria cat = categoriaService.save(categoria);
        return cat;
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria cat = categoriaService.update(categoria);
        return cat;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoriaService.delete(id);

    }

}
