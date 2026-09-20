package br.edu.utfpr.books.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookEntity {

    private Integer id;

    private String titulo;

    private String autor;

    private Integer quantidadePaginas;

    private Float preco;

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof BookEntity book) {
            return this.id.equals(book.getId());
        }
        return false;
    }
}
