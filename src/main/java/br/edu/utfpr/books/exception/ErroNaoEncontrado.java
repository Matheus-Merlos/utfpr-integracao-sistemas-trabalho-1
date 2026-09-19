package br.edu.utfpr.books.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErroNaoEncontrado {
    String titulo;

    Integer status;

    String mensagem;
}
