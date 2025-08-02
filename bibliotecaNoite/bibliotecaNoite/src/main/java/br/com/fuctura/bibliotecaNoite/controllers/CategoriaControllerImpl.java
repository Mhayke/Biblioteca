package br.com.fuctura.bibliotecaNoite.controllers;

import br.com.fuctura.bibliotecaNoite.controllers.interfaces.CategoriaController;
import br.com.fuctura.bibliotecaNoite.dtos.CategoriaDto;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaControllerImpl implements CategoriaController {

    //@GetMapping("/{id}") = // Método para buscar uma categoria pelo ID
    //@GetMapping = // Método para listar todas as categorias
    //@PostMapping = // Método para criar uma nova categoria
    //@PutMapping("/{id}") = // Método para atualizar uma categoria existente
    // @DeleteMapping("/{id}") = // Método para deletar uma categoria pelo ID

    @Autowired
    private CategoriaService categoriaService;

    @Autowired // Anotação para injeção de dependência do serviço de categorias
    private ModelMapper modelMapper; // Injeção de dependência do ModelMapper para conversão entre entidades e DTOs

    @GetMapping("/{id}") // Método para buscar uma categoria pelo ID
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @GetMapping // Método para listar todas as categorias
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDto> listDto = new ArrayList<>();

        for (Categoria categoria : list) {
            listDto.add(modelMapper.map(categoria, CategoriaDto.class));
        }
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/nome/{nome}") // Método para buscar uma categoria pelo nome
    public ResponseEntity<CategoriaDto> findByNome(@PathVariable String nome) {
        Categoria cat = categoriaService.findByNome(nome);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));

    }

    @PostMapping // Método para criar uma nova categoria
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto) {
        Categoria cat = categoriaService.save(modelMapper.map(categoriaDto, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @PutMapping("/{id}") // Método para atualizar uma categoria existente
    public ResponseEntity<CategoriaDto> update(@PathVariable Integer id, @RequestBody CategoriaDto categoriaDto) {
        categoriaDto.setId(id);
        Categoria cat = categoriaService.update(modelMapper.map(categoriaDto, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @DeleteMapping("/{id}") // Método para deletar uma categoria pelo ID
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build(); // Retorna uma resposta sem conteúdo (204 No Content)
    }

}
