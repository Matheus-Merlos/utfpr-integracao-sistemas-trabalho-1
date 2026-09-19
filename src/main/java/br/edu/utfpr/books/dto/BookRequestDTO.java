package br.edu.utfpr.books.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookRequestDTO {

    @NotBlank(message = "Título Obrigatório.")
    @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres.")
    String titulo;

    @NotBlank(message = "Autor Obrigatório.")
    String autor;

    @NotNull()
    @Positive(message = "A quantidade de paginas deve ser positiva")
    @Min(value = 1, message = "Deve ter no mínimo 1 página")
    Integer quantidadePaginas;

    @Positive(message = "O preço deve ser maior que zero")
    Float preco;
}
