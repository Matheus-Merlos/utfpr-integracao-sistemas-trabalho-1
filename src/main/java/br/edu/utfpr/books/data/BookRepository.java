package br.edu.utfpr.books.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import br.edu.utfpr.books.domain.Book;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookRepository {

    public static int currentId = 1;

    private final List<BookEntity> database = new ArrayList<>();

    private final BookDataMapper mapper;

    public List<Book> findAll() {

        return this.database.stream().map(mapper::toDomain).toList();
    }

    public Book criarLivro(Book book) {

        BookEntity entity = mapper.toEntity(book);

        database.add(entity);
        currentId++;

        return mapper.toDomain(entity);
    }

    public Optional<Book> findById(int id) {

        return this.database.stream()
                .map(mapper::toDomain)
                .filter(data -> data.getId() == id)
                .findFirst();
    }

    public Book updateLivro(Book book) {

        for (BookEntity entity : this.database) {
            if (Objects.equals(entity.getId(), book.getId())) {
                entity.setAutor(book.getAutor());
                entity.setPreco(book.getPreco());
                entity.setQuantidadePaginas(book.getQuantidadePaginas());
                entity.setTitulo(book.getTitulo());
                return mapper.toDomain(entity);
            }
        }
        return book;
    }

    public void deleteLivro(int id) {

        this.database.removeIf(entity -> entity.getId() == id);
    }
}
