package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import br.com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional // Transações são gerenciadas automaticamente pelo Spring
public class LivroService {

    // Logger para registrar informações e erros
    private static final Logger log = LoggerFactory.getLogger(LivroService.class);

    @Autowired
    private LivroRepository livroRepository; // Injeção de dependência do repositório de livros

    @Autowired
    private CategoriaService categoriaService; // Injeção de dependência do serviço de categorias, caso necessário

    // Método para listar todos os livros
    public List<Livro> findAll() {
        log.info("Listando todos os livros de todas as categorias"); // Loga a listagem de todos os livros
        List<Categoria> cat = categoriaService.findAll();
        List<Livro> liv = new ArrayList<>();

        for (Categoria categoria : cat) { // Itera sobre todas as categorias
            if (categoria.getLivros() != null && !categoria.getLivros().isEmpty()) { // Verifica se a categoria possui livros
                liv.addAll(categoria.getLivros()); // Adiciona os livros da categoria à lista
            }
        }
        if (liv.isEmpty()) { // Verifica se não há livros
            log.warn("Nenhum livro encontrado em nenhuma categoria"); // Loga um aviso se não houver livros
            throw new NotFoundException("Nenhum livro encontrado em nenhuma categoria.");
        }
        log.info("Total de livros encontrados: {}", liv.size()); // Loga o total de livros encontrados
        return liv;
    }

    // Método para buscar um livro pelo ID
    public Livro findById(Integer id) {
        log.info("Buscando livro com o ID: {}", id); // Loga a busca pela livro
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isPresent()) {
            log.info("Livro encontrado com o ID: {}", id); // Loga o livro encontrado
            return livro.get();
        }
        log.error("Livro não encontrado com o ID: {}", id); // Loga o erro se o livro não for encontrado
        throw new br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException("Livro não encontrado com o ID: " + id);
    }

    // Método para buscar um livro pelo autor
    public Livro findByAutor(String autor) {
        log.info("Buscando livro pelo autor: {}", autor); // Loga a busca pelo autor
        Livro livro = livroRepository.findByAutor(autor);
        if (livro != null) {
            log.info("Livro encontrado pelo autor: {}", autor); // Loga o livro encontrado pelo autor
            return livro;
        }
        log.error("Livro não encontrado pelo autor: {}", autor); // Loga o erro se o livro não for encontrado pelo autor
        throw new br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException("Livro não encontrado pelo autor: " + autor);
    }

    // Método para salvar um novo livro
    public Livro save(Livro livro) {
        log.info("Salvando novo livro: {}", livro.getTitulo()); // Loga a tentativa de salvar um novo livro
        if (livro.getId() != null) { // Verifica se o ID foi informado manualmente
            log.error("Tentativa de salvar livro com ID manualmente informado: {}", livro.getId()); // Loga o erro se o ID foi informado
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Não é permitido informar o ID manualmente.");
        }
        log.info("Livro salvo com sucesso: {}", livro.getTitulo()); // Loga o sucesso
        return livroRepository.save(livro); // Salva o livro no repositório
    }

    // Método para atualizar um livro existente
    public Livro update(Livro livro) {
        Livro liv = findById(livro.getId()); // Busca o livro existente pelo ID
        log.info("Atualizando livro com o ID: {}", livro.getId()); // Loga a tentativa de atualizar o livro
        if (liv.getId() == null) { // Verifica se o ID do livro existente é nulo
            log.error("Tentativa de atualizar livro com ID nulo: {}", livro.getId()); // Loga o erro se o ID for nulo
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Não é permitido atualizar um livro com ID nulo.");
        }
        liv.setTitulo(liv.getTitulo());
        liv.setAutor(liv.getAutor());
        liv.setSinopse(liv.getSinopse());
        liv.setTamanho(liv.getTamanho());
        log.info("Livro atualizado com sucesso: {}", livro.getTitulo()); // Loga o sucesso
        return livroRepository.save(livro); // Atualiza o livro no repositório
    }

    // Método para deletar um livro pelo ID
    public void deleteById(Integer id) {
        log.info("Deletando livro com o ID: {}", id); // Loga a tentativa de deletar um livro
        if (!livroRepository.existsById(id)) { // Verifica se o livro existe
            log.error("Livro não encontrado com o ID: {}", id); // Loga o erro se o livro não for encontrado
            throw new br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException("Livro não encontrado com o ID: " + id);
        }
        log.info("Livro deletado com sucesso: {}", id); // Loga o sucesso ao deletar o livro
        livroRepository.deleteById(id); // Deleta o livro do repositório
    }

}
