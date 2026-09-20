package br.edu.utfpr.books.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import br.edu.utfpr.books.api.dto.BookRequestDTO;
import br.edu.utfpr.books.api.dto.BookResponseDTO;
import br.edu.utfpr.books.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookApiMapper {

    public Book toDomain(BookRequestDTO dto) {

        return Book.builder()
                .titulo(dto.titulo())
                .autor(dto.autor())
                .preco(dto.preco())
                .quantidadePaginas(dto.quantidadePaginas())
                .build();
    }

    public BookResponseDTO toDto(Book domain) {

        return new BookResponseDTO(domain.getId(), domain.getTitulo(), domain.getAutor(),
                domain.getQuantidadePaginas(), domain.getPreco());
    }

    public List<BookResponseDTO> toDto(List<Book> domain) {

        return domain.stream().map(this::toDto).collect(Collectors.toList());
    }
}
