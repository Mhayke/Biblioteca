package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.exceptions.DataIntegrityViolationException;
import br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException;
import br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import br.com.fuctura.bibliotecaNoite.repositories.CategoriaRepository;
import br.com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository; // Injeção de dependência do repositório de categorias

    // Método para buscar uma categoria pelo ID
    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if ( cat.isPresent() ) {
            return cat.get();
        }
        throw new NotFoundException("Categoria não encontrada com o ID: " + id);
    }

    // Método para listar todas as categorias
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Método para salvar uma nova categoria
    public Categoria save(Categoria categoria) {
        if (categoria.getId() != null) { // Verifica se o ID foi informado manualmente
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Não é permitido informar o ID manualmente.");
        }
        if (categoria.getNome().isEmpty()) { // Verifica se o nome da categoria está vazio
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Nome da categoria precisa ser preenchida.");
        }
        return categoriaRepository.save(categoria);
    }

    // Método para atualizar uma categoria existente
    public Categoria update(Categoria categoria) { // Verifica se a categoria existe e atualiza seus dados
        if (categoriaRepository.findById(categoria.getId()).isEmpty()) { // Verifica se a categoria existe
            throw new NotFoundException("Categoria não encontrada com o ID: " + categoria.getId());
        }
        if (categoria.getNome().isEmpty()) { // Verifica se o nome da categoria está vazio
            throw new IllegalArgumentException("Nome da categoria precisa ser preenchida.");
        }
        if (categoria.getDescricao().isEmpty()) { // Verifica se a descrição da categoria está vazia
            throw new IllegalArgumentException("Descrição da categoria precisa ser preenchida.");
        }
        return categoriaRepository.save(categoria);
    }

    // Método para deletar uma categoria pelo ID
    public void delete(Integer id) {
        if (categoriaRepository.findById(id).isEmpty()) { // Verifica se a categoria existe
            throw new NotFoundException("Categoria não encontrada para ser deletada com o ID: " + id);
        }
        if (!categoriaRepository.findById(id).get().getLivros().isEmpty()) { // Verifica se a categoria possui livros associados
            throw new DataIntegrityViolationException("Não é possível deletar a categoria com ID: " + id + " porque ela possui livros associados.");
        }
        categoriaRepository.deleteById(id);
    }

    // Método para buscar uma categoria pelo nome
    public Categoria findByNome(String nome) {
        Categoria cat = categoriaRepository.findByNome(nome);
        if ( cat != null ) { // Verifica se a categoria foi encontrada
            return cat;
        }
        throw new NotFoundException("Categoria não encontrada com o nome: " + nome);
    }

}
