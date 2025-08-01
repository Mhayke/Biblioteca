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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> findById(@PathVariable Integer id) {
        Categoria cat = categoriaService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        //return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDto.class)).collect(Collectors.toList()));
        List<CategoriaDto> listDto = new ArrayList<>();

        for (Categoria categoria : list) {
            listDto.add(modelMapper.map(categoria, CategoriaDto.class));
        }

        return ResponseEntity.ok().body(listDto);
    }

    @Override
    @GetMapping("/nome/{nome}")
    public ResponseEntity<CategoriaDto> findByNome(@PathVariable String nome) {
        Categoria cat = categoriaService.findByNome(nome);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));

    }

    @PostMapping
    public ResponseEntity<CategoriaDto> save(@RequestBody CategoriaDto categoriaDto) {
        Categoria cat = categoriaService.save(modelMapper.map(categoriaDto, Categoria.class));
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDto.class));
    }

    @Override
    public ResponseEntity<CategoriaDto> update(Integer id, CategoriaDto categoriaDto) {
        return null;
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
