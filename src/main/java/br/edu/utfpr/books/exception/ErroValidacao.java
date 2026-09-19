package br.edu.utfpr.books.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ErroValidacao {

    Integer status;

    String mensagem;

    String uri;

    List<CampoErro> erros;
}
