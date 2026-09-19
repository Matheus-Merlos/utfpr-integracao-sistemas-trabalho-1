package br.edu.utfpr.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder()
@Data()
@AllArgsConstructor()
public class BookResponseDTO {
    Integer id;

    String titulo;

    String autor;

    Integer quantidadePaginas;

    Float preco;
}
