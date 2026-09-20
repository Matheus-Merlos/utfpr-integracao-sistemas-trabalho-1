package br.edu.utfpr.books.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookRequestDTO(

        @NotBlank(message = "Título Obrigatório.")
        @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres.")
        String titulo,

        @NotBlank(message = "Autor Obrigatório.")
        String autor,

        @NotNull()
        @Min(value = 1, message = "Deve ter no mínimo 1 página")
        Integer quantidadePaginas,

        @Positive(message = "O preço deve ser maior que zero")
        Float preco
) {

}
