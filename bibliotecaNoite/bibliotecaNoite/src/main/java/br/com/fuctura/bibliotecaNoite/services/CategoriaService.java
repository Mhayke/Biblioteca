package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.orElse(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        Categoria cat = categoriaRepository.save(categoria);
        return cat;
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);

    }

    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria findByNome(String nome) {
        Optional<Categoria> cat = categoriaRepository.findByNomeIgnoreCaseContaining(nome);
        return cat.orElse(null);
    }
}
