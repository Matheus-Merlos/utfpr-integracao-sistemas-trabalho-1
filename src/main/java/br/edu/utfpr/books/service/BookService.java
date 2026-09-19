package br.edu.utfpr.books.service;

import br.edu.utfpr.books.dto.BookRequestDTO;
import br.edu.utfpr.books.dto.BookResponseDTO;
import br.edu.utfpr.books.exception.LivroNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    public static int currentId = 1;
    public List<BookResponseDTO> database = new ArrayList<>();

    public List<BookResponseDTO> getLivros() {
        return this.database;
    }

    public synchronized BookResponseDTO criarLivro(BookRequestDTO body) {
        BookResponseDTO bodyWithId = BookResponseDTO.builder()
                .id(currentId)
                .titulo(body.getTitulo())
                .autor(body.getAutor())
                .preco(body.getPreco())
                .quantidadePaginas(body.getQuantidadePaginas())
                .build();

        database.add(bodyWithId);

        currentId++;

        return bodyWithId;
    }

    public BookResponseDTO findById(int id) {
        for(BookResponseDTO data : this.database) {
            if(data.getId() == id) {
                return data;
            }
        }
        throw new LivroNaoEncontradoException(String.format("Nenhum livro foi encontrado com o id %d.", id));
    }

    public BookResponseDTO updateLivro(int id, BookRequestDTO body) {
        for(BookResponseDTO data : this.database) {
            if(data.getId() == id) {
                data.setAutor(body.getAutor());
                data.setPreco(body.getPreco());
                data.setQuantidadePaginas(body.getQuantidadePaginas());
                data.setTitulo(body.getTitulo());
                return data;
            }
        }
        throw new LivroNaoEncontradoException(String.format("Nenhum livro foi encontrado com o id %d.", id));
    }

    public void deleteLivro(int id) {
        this.findById(id);

        for(BookResponseDTO data : this.database) {
            if(data.getId() == id) {
                this.database.remove(data);
            }
        }
    }
}
