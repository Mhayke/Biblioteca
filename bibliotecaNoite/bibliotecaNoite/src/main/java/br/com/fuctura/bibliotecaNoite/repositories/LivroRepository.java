package br.com.fuctura.bibliotecaNoite.repositories;

import br.com.fuctura.bibliotecaNoite.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {



}
