package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongRepository;

@Component
public class Populator  implements CommandLineRunner {

    private AlbumRepository albumRepo;
    private SongRepository songRepo;

    public Populator(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Album Jworld = new Album("Legends never Die", "https://i.discogs.com/O7_-5er5eB0InrMFdHS2Ew6aBMAvnKAMG4f-7uvVrPA/rs:fit/g:sm/q:90/h:599/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE2MTU1/NDY3LTE2MDkxOTEz/NTUtMTk0OC5qcGVn.jpeg","idkLabel"
        , 5);
        Album LilYacthy = new Album("Lil Boat 2", "https://media.pitchfork.com/photos/5aa1c22aba1f20076b95344a/1:1/w_600/lilboat2.jpeg"
        ,"idkLabel",5);

        albumRepo.save(Jworld);
        albumRepo.save(LilYacthy);

        Song song1 = new Song("Self Made", "https://open.spotify.com/track/3Uvi9diL18dYSUc3vcKk0n?si=c8b2e1d72d1f4d4d"
        ,"1:52",4,LilYacthy);

        Song song2 = new Song("Conversations","https://open.spotify.com/track/4K06PO78fW4mnBVenxGNob?si=7c77a107f7b8467d",
                "3:01", 2,Jworld);

        songRepo.save(song1);
        songRepo.save(song2);


    }
}
