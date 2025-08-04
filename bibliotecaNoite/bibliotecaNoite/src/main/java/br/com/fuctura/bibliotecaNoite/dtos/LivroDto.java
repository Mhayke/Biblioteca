package br.com.fuctura.bibliotecaNoite.dtos;

import br.com.fuctura.bibliotecaNoite.enuns.Tamanho;
import br.com.fuctura.bibliotecaNoite.models.Categoria;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LivroDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O título do livro não pode ser nulo.")
    private String titulo;
    @NotNull(message = "O autor do livro não pode ser nulo.")
    private String autor;
    @NotNull(message = "A sinopse do livro não pode ser nula.")
    @Size(min = 10, max = 500, message = "A sinopse deve ter entre 10 e 500 caracteres.")
    private String sinopse;
    @NotNull(message = "A categoria do livro não pode ser nula.")
    private Categoria categoria;
    @NotNull(message = "O tamanho do livro não pode ser nulo.")
    private Tamanho tamanho;

    // Construtor vazio necessário para a serialização
    public LivroDto() {
    }

    // Construtor com parâmetros
    public LivroDto(Integer id, Tamanho tamanho, Categoria categoria, String sinopse, String autor, String titulo) {
        this.id = id;
        this.tamanho = tamanho;
        this.categoria = categoria;
        this.sinopse = sinopse;
        this.autor = autor;
        this.titulo = titulo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
