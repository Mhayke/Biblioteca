package br.com.fuctura.bibliotecaNoite.controllers;

import br.com.fuctura.bibliotecaNoite.controllers.interfaces.LivroController;
import br.com.fuctura.bibliotecaNoite.dtos.LivroDto;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import br.com.fuctura.bibliotecaNoite.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroControllerImpl implements LivroController {

    @Autowired
    private LivroService livroService; // Injeção de dependência do serviço de livros

    @Autowired
    private ModelMapper modelMapper; // Injeção de dependência do ModelMapper para conversão entre entidades e DTOs

    @GetMapping
    public ResponseEntity<List<LivroDto>> findAll() {
        List<Livro> livros = livroService.findAll(); // Chama o serviço para listar todos os livros
        List<LivroDto> livroDtos = new ArrayList<>();
        for (Livro livro : livros) {
            livroDtos.add(modelMapper.map(livro, LivroDto.class)); // Converte cada livro para LivroDto
        }
        return ResponseEntity.ok().body(livroDtos); // Retorna a lista de Livro
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id); // Chama o serviço para buscar um livro pelo ID
        LivroDto livroDto = modelMapper.map(livro, LivroDto.class); // Converte o livro para LivroDto
        return ResponseEntity.ok().body(livroDto); // Retorna o LivroDto encontrado
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<LivroDto> findByAutor(String autor) {
        Livro livro = livroService.findByAutor(autor); // Chama o serviço para buscar um livro pelo autor
        LivroDto livroDto = modelMapper.map(livro, LivroDto.class); // Converte o livro para LivroDto
        return ResponseEntity.ok().body(livroDto); // Retorna o LivroDto encontrado
    }

    @PostMapping
    public ResponseEntity<LivroDto> save(@Valid @RequestBody LivroDto livroDto) {
        Livro livro = modelMapper.map(livroDto, Livro.class); // Converte LivroDto para Livro
        Livro savedLivro = livroService.save(livro); // Chama o serviço para salvar o livro
        LivroDto savedLivroDto = modelMapper.map(savedLivro, LivroDto.class); // Converte o livro salvo para LivroDto
        return ResponseEntity.ok().body(savedLivroDto); // Retorna o LivroDto salvo
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDto> update(@Valid  @PathVariable Integer id, @RequestBody LivroDto livroDto) {
        Livro livro = modelMapper.map(livroDto, Livro.class); // Converte LivroDto para Livro
        livro.setId(id); // Define o ID
        Livro updatedLivro = livroService.update(livro); // Chama o serviço para atualizar
        LivroDto updatedLivroDto = modelMapper.map(updatedLivro, LivroDto.class); // Converte o livro atualizado para LivroDto
        return ResponseEntity.ok().body(updatedLivroDto); // Retorna o LivroDto atualizado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        livroService.deleteById(id); // Chama o serviço para deletar o livro pelo ID
        return ResponseEntity.noContent().build(); // Retorna resposta sem conteúdo
    }

    @Override
    public ResponseEntity<LivroDto> update(LivroDto livroDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Integer id) {
        return null;
    }


}
