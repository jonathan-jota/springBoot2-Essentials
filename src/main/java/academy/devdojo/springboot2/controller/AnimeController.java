package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("anime")
@Slf4j
@RequiredArgsConstructor//gera um constructor com todos os atributos do tipo final
public class AnimeController {

    private final DateUtil dateUtil;

//    @Autowired
//    public AnimeController(DateUtil dateUtil) {
//        this.dateUtil = dateUtil;
//    };

    @GetMapping(path="/list")
    public List<Anime> listAll() {
        log.info("Date Formatted {}", dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return Arrays.asList(
                new Anime ("Naruto"),
                new Anime("DBZ"),
                new Anime("CDZ"));
    }
}
