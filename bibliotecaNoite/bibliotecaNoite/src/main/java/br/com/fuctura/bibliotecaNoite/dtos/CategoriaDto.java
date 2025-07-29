package br.com.fuctura.bibliotecaNoite.dtos;

import br.com.fuctura.bibliotecaNoite.models.Livro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
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
