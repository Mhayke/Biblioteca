package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.exceptions.DataIntegrityViolationException;
import br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException;
import br.com.fuctura.bibliotecaNoite.exceptions.NotFoundException;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.repositories.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional // Transações são gerenciadas automaticamente pelo Spring
public class CategoriaService {

    // Logger para registrar informações e erros
    private static final Logger log = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private CategoriaRepository categoriaRepository; // Injeção de dependência do repositório de categorias

    // Método para buscar uma categoria pelo ID
    public Categoria findById(Integer id) {
        log.info("Buscando categoria com o ID: {}", id); // Loga a busca pela categoria
        Optional<Categoria> cat = categoriaRepository.findById(id);
        if ( cat.isPresent() ) {
            log.info("Categoria encontrada com o ID: {}", id); // Loga a categoria encontrada
            return cat.get();
        }
        log.error("Categoria não encontrada com o ID: {}", id); // Loga o erro se a categoria não for encontrada
        throw new NotFoundException("Categoria não encontrada com o ID: " + id);
    }

    // Método para listar todas as categorias
    public List<Categoria> findAll() {
        log.info("Listando todas as categorias"); // Loga a listagem de todas as categorias
        if (categoriaRepository.findAll().isEmpty()) { // Verifica se não há categorias
            log.warn("Nenhuma categoria encontrada"); // Loga um aviso se não houver categorias
            throw new NotFoundException("Nenhuma categoria encontrada.");
        }
        log.info("Total de categorias encontradas: {}", categoriaRepository.findAll().size()); // Loga o total de categorias encontradas
        return categoriaRepository.findAll();
    }

    // Método para salvar uma nova categoria
    public Categoria save(Categoria categoria) {
        log.info("Salvando nova categoria: {}", categoria.getNome()); // Loga a tentativa de salvar uma nova categoria
        if (categoria.getId() != null) { // Verifica se o ID foi informado manualmente
            log.error("Tentativa de salvar categoria com ID manualmente informado: {}", categoria.getId()); // Loga o erro se o ID foi informado
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Não é permitido informar o ID manualmente.");
        }
        if (categoria.getNome().isEmpty()) { // Verifica se o nome da categoria está vazio
            log.error("Nome da categoria não pode ser vazio"); // Loga o erro se o nome estiver vazio
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Nome da categoria precisa ser preenchida.");
        }
        if (categoria.getDescricao().isEmpty()) { // Verifica se a descrição da categoria está vazia
            log.error("Descrição da categoria não pode ser vazia"); // Loga o erro se a descrição estiver vazia
            throw new br.com.fuctura.bibliotecaNoite.exceptions.IllegalArgumentException("Descrição da categoria precisa ser preenchida.");
        }
        log.info("Categoria salva com sucesso: {}", categoria.getNome()); // Loga o sucesso ao salvar a categoria
        return categoriaRepository.save(categoria);
    }

    // Método para atualizar uma categoria existente
    public Categoria update(Categoria categoria) { // Verifica se a categoria existe e atualiza seus dados
        log.info("Atualizando categoria com o ID: {}", categoria.getId()); // Loga a tentativa de atualizar uma categoria
        if (categoriaRepository.findById(categoria.getId()).isEmpty()) { // Verifica se a categoria existe
            log.error("Categoria não encontrada para atualização com o ID: {}", categoria.getId()); // Loga o erro se a categoria não for encontrada
            throw new NotFoundException("Categoria não encontrada com o ID: " + categoria.getId());
        }
        if (categoria.getNome().isEmpty()) { // Verifica se o nome da categoria está vazio
            log.error("Nome da categoria não pode ser vazio"); // Loga o erro se o nome estiver vazio
            throw new IllegalArgumentException("Nome da categoria precisa ser preenchida.");
        }
        if (categoria.getDescricao().isEmpty()) { // Verifica se a descrição da categoria está vazia
            log.error("Descrição da categoria não pode ser vazia"); // Loga o erro se a descrição estiver vazia
            throw new IllegalArgumentException("Descrição da categoria precisa ser preenchida.");
        }
        log.info("Categoria atualizada com sucesso: {}", categoria.getNome()); // Loga o sucesso ao atualizar a categoria
        return categoriaRepository.save(categoria);
    }

    // Método para deletar uma categoria pelo ID
    public void delete(Integer id) {
        log.info("Deletando categoria com o ID: {}", id); // Loga a tentativa de deletar uma categoria
        if (categoriaRepository.findById(id).isEmpty()) { // Verifica se a categoria existe
            log.error("Categoria não encontrada para deletar com o ID: {}", id); // Loga o erro se a categoria não for encontrada
            throw new NotFoundException("Categoria não encontrada para ser deletada com o ID: " + id);
        }
        if (!categoriaRepository.findById(id).get().getLivros().isEmpty()) { // Verifica se a categoria possui livros associados
            log.error("Não é possível deletar a categoria com o ID: {} porque ela possui livros associados.", id); // Loga o erro se a categoria tiver livros
            throw new DataIntegrityViolationException("Não é possível deletar a categoria com ID: " + id + " porque ela possui livros associados.");
        }
        log.info("Categoria deletada com sucesso com o ID: {}", id); // Loga o sucesso ao deletar a categoria
        categoriaRepository.deleteById(id);
    }

    // Método para buscar uma categoria pelo nome
    public Categoria findByNome(String nome) {
        log.info("Buscando categoria com o nome: {}", nome); // Loga a busca pela categoria pelo nome
        Categoria cat = categoriaRepository.findByNome(nome);
        if ( cat != null ) { // Verifica se a categoria foi encontrada
            log.info("Categoria encontrada com o nome: {}", nome); // Loga a categoria encontrada
            return cat;
        }
        log.error("Categoria não encontrada com o nome: {}", nome); // Loga o erro se a categoria não for encontrada
        throw new NotFoundException("Categoria não encontrada com o nome: " + nome);
    }

}
