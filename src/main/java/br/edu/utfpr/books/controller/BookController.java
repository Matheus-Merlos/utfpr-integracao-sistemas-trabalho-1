package br.edu.utfpr.books.controller;

import br.edu.utfpr.books.dto.BookRequestDTO;
import br.edu.utfpr.books.dto.BookResponseDTO;
import br.edu.utfpr.books.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping("/livros")
    public ResponseEntity<List<BookResponseDTO>> getLivros() {
        return ResponseEntity.ok(bookService.getLivros());
    }

    @PostMapping("/livros")
    public ResponseEntity<BookResponseDTO> criarLivro(@Valid @RequestBody BookRequestDTO body) {
        BookResponseDTO livroCriado = bookService.criarLivro(body);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroCriado.getId())
                .toUri();

        return ResponseEntity.created(location).body(livroCriado);
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity<BookResponseDTO> getLivroById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<BookResponseDTO> updateLivro(@PathVariable int id, @Valid @RequestBody BookRequestDTO body) {
        return ResponseEntity.ok(bookService.updateLivro(id, body));
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable int id) {
        bookService.deleteLivro(id);

        return ResponseEntity.noContent().build();
    }
}
