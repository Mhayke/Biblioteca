package br.com.fuctura.bibliotecaNoite.services;

import br.com.fuctura.bibliotecaNoite.enuns.Tamanho;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import br.com.fuctura.bibliotecaNoite.models.Livro;
import br.com.fuctura.bibliotecaNoite.repositories.CategoriaRepository;
import br.com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDB() {

        Categoria cat1 = new Categoria(null, "Infórmatica", "Livros de infórmatica");
        Categoria cat2 = new Categoria(null, "Ficção científica", "Livros de ficção científica");
        Categoria cat3 = new Categoria(null, "Biografia", "Livros de biografias");

        Livro l1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", Tamanho.MEDIO, cat1);
        Livro l2 = new Livro(null, "Engenharia do software", "Louis V. Gerstner", "Lorem ipsum", Tamanho.GRANDE, cat1);
        Livro l3 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", Tamanho.PEQUENO, cat2);
        Livro l4 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", Tamanho.MEDIO, cat2);
        Livro l5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", Tamanho.GRANDE, cat2);

        cat1.getLivros().addAll(Arrays.asList(l1, l2));
        cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }

}
