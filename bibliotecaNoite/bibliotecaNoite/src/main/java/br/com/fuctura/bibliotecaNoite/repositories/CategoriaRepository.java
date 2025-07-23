package br.com.fuctura.bibliotecaNoite.repositories;

import br.com.fuctura.bibliotecaNoite.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    // Métodos adicionais de consulta podem ser definidos aqui, se necessário
    // Exemplo: List<Categoria> findByNomeContaining(String nome);
}
