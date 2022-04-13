package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimeRepository {

    public List<Anime> listAll() {
        return List.of(
                new Anime(1, "DBZ"),
                new Anime(2, "CDZ"),
                new Anime(3, "Naruto")
        );
    }
}
