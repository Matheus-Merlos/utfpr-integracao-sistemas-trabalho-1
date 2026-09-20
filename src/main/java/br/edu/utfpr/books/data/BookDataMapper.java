package br.edu.utfpr.books.data;

import br.edu.utfpr.books.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDataMapper {

    public BookEntity toEntity(Book book) {

        return BookEntity.builder()
                .id(book.getId())
                .titulo(book.getTitulo())
                .autor(book.getAutor())
                .quantidadePaginas(book.getQuantidadePaginas())
                .preco(book.getPreco())
                .build();
    }

    public Book toDomain(BookEntity entity) {

        return Book.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .autor(entity.getAutor())
                .quantidadePaginas(entity.getQuantidadePaginas())
                .preco(entity.getPreco())
                .build();
    }
}
