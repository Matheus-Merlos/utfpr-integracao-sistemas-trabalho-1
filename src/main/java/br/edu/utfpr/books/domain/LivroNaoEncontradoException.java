package br.edu.utfpr.books.domain;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(final String message) {
        super(message);
    }
}
