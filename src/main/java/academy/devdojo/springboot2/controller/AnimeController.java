package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.repository.AnimeRepository;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Slf4j
@RequiredArgsConstructor//gera um constructor com todos os atributos do tipo final
public class AnimeController {

    private final DateUtil dateUtil;
    private final AnimeRepository animeRepository;

    @GetMapping
    public ResponseEntity<List<Anime>> listAll() {
        log.info("Date Formatted {}", dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeRepository.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable int id) {

        Anime animeFound = animeRepository.listAll()
                .stream()
                .filter(anime -> anime.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Anime Not Found"));

        return ResponseEntity.ok(animeFound);
    }
}
