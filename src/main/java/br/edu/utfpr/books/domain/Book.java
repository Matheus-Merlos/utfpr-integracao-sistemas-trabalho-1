package br.edu.utfpr.books.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Book {

    private Integer id;

    private String titulo;

    private String autor;

    private Integer quantidadePaginas;

    private Float preco;
}
