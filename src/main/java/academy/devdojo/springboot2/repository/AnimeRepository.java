package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class AnimeRepository {
    private static List<Anime> animes;
    static {
        animes = new ArrayList<>(List.of(
                new Anime(1, "DBZ"),
                new Anime(2, "CDZ"),
                new Anime(3, "Naruto")
                ));
    }
    public List<Anime> listAll() {
        return animes;
    }
    
    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextInt(4, 1000000));
        animes.add(anime);
        return anime;
    }
}
