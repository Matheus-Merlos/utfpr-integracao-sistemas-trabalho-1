package br.edu.utfpr.books.api;

import java.net.URI;
import java.util.List;

import br.edu.utfpr.books.api.dto.BookRequestDTO;
import br.edu.utfpr.books.api.dto.BookResponseDTO;
import br.edu.utfpr.books.api.mapper.BookApiMapper;
import br.edu.utfpr.books.domain.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/livros")
public class BookController {

    private final BookApiMapper mapper;

    private final BookService service;
    @GetMapping()
    public ResponseEntity<List<BookResponseDTO>> getLivros() {

        return ResponseEntity.ok(mapper.toDto(service.getAll()));
    }

    @PostMapping()
    public ResponseEntity<BookResponseDTO> criarLivro(@Valid @RequestBody BookRequestDTO body) {

        BookResponseDTO livroCriado = mapper.toDto(service.save(mapper.toDomain(body)));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livroCriado.id())
                .toUri();

        return ResponseEntity.created(location).body(livroCriado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getLivroById(@PathVariable int id) {

        return ResponseEntity.ok(mapper.toDto(service.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateLivro(@PathVariable int id, @Valid @RequestBody BookRequestDTO body) {

        return ResponseEntity.ok(mapper.toDto(service.update(id, mapper.toDomain(body))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable int id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
