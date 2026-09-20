package br.edu.utfpr.books.domain;

import java.util.List;

import br.edu.utfpr.books.data.BookRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public Book getById(int id) {

        return repository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(
                        String.format("Nenhum livro foi encontrado com o id %d.", id)));
    }

    public Book save(Book book) {

        return repository.criarLivro(book);
    }

    public List<Book> getAll() {

        return repository.findAll();
    }

    public Book update(int id, Book book) {

        getById(id);
        book.setId(id);
        return repository.updateLivro(book);
    }

    public void deleteById(int id) {

        repository.deleteLivro(id);
    }
}