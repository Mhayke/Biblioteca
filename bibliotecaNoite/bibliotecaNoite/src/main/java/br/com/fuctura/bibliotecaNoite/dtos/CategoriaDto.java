package br.com.fuctura.bibliotecaNoite.dtos;

import br.com.fuctura.bibliotecaNoite.models.Livro;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O nome da categoria não pode ser nulo.")
    private String nome;
    @NotNull(message = "A descrição da categoria não pode ser nula.")
    private String descricao;

    // construtor vazio necessário para a serialização
    public CategoriaDto() {
    }

    // construtor com parâmetros
    public CategoriaDto(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    // getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
