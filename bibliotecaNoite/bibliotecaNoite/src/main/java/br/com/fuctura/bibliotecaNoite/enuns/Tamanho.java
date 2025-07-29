package br.com.fuctura.bibliotecaNoite.enuns;

public enum Tamanho {

    PEQUENO(0),
    MEDIO(1),
    GRANDE(2);

    private int codigo;

    Tamanho(int codigo) {
        this.codigo = codigo;
    }
}
