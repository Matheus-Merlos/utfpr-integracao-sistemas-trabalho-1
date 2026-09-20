package br.edu.utfpr.books.api.dto;

public record BookResponseDTO(

        Integer id,

        String titulo,

        String autor,

        Integer quantidadePaginas,

        Float preco
) {

}
