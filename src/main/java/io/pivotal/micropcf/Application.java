package io.pivotal.micropcf;

import io.pivotal.micropcf.domain.AOR;
import io.pivotal.micropcf.domain.Track;
import io.pivotal.micropcf.repositories.MongoAORRepository;
import io.pivotal.micropcf.repositories.MongoTrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner seed(final MongoTrackRepository track) {
//        return args -> Arrays.asList("3e46917a030c460fcf1263ed6f9222df77b369a4,270", "d6d70f516c57fd3fa30896bdd1118aad985ee41a,159", "d6d70f516c57fd3fa30896bdd1118aad985ee41a,090").stream()
//                .map(s -> s.split(","))
//                .forEach(namePair -> track.save(new Track(namePair[0], namePair[1])));
//    }

}

@Service
class DatabaseLoader
{
    private final MongoTrackRepository TrackRepository;
    private final MongoAORRepository AORRepository;

    @Autowired
    public DatabaseLoader(MongoTrackRepository TrackRepository, MongoAORRepository AORRepository) {
        this.TrackRepository = TrackRepository;
        this.AORRepository = AORRepository;
    }

    @PostConstruct
    private void initDatabase() {
        AORRepository.deleteAll();
        TrackRepository.deleteAll();

        AOR aor = new AOR("Asia Pacific");
        AORRepository.save(aor);

        Track one = new Track("3e46917a030c460fcf1263ed6f9222df77b369a4", "270");
        one.setAorId(aor.getId());
        TrackRepository.save(one);

        Track two = new Track("d6d70f516c57fd3fa30896bdd1118aad985ee41a", "159");
        two.setAorId(aor.getId());
        TrackRepository.save(two);

        Track three = new Track("d6d70f516c57fd3fa30896bdd1118aad985ee41a", "090");
        three.setAorId(aor.getId());
        TrackRepository.save(three);

        aor.setTracks(Arrays.asList(new Track[]{one, two, three}));
        AORRepository.save(aor);
    }
}
