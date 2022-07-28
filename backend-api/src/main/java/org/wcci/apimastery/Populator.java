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
        Album Sublime = new Album("Sublime", "https://i.scdn.co/image/ab67616d0000b2738fc4b0dcfb9509553f195c85"
        ,"MCA",5);
        Album TheBlackEyePeas = new Album("The Beginning", "https://m.media-amazon.com/images/I/6129yfRYLRL._SL1200_.jpg"
        ,"Interscope",5);
        Album DrDre = new Album("Dr. Dre: Chronic 2001", "https://m.media-amazon.com/images/I/51FUauZ5NEL._SX355_.jpg"
        ,"Death Row Records",5);
        Album Eminem = new Album("The Marshall Mathers LP", "https://m.media-amazon.com/images/I/813Is33yOzL._SL1400_.jpg"
        ,"Interscope",5);

        albumRepo.save(Jworld);
        albumRepo.save(LilYacthy);
        albumRepo.save(Sublime);
        albumRepo.save(TheBlackEyePeas);
        albumRepo.save(DrDre);
        albumRepo.save(Eminem);

        Song song1 = new Song("Self Made", "https://open.spotify.com/track/3Uvi9diL18dYSUc3vcKk0n?si=c8b2e1d72d1f4d4d"
        ,"1:52",4,LilYacthy);

        Song song2 = new Song("Conversations","https://open.spotify.com/track/4K06PO78fW4mnBVenxGNob?si=7c77a107f7b8467d",
                "3:01", 2,Jworld);

        Song song3 = new Song("Santaria", "https://open.spotify.com/track/2hnMS47jN0etwvFPzYk11f", "2:50", 5, Sublime);  
        
        Song song4 = new Song("Just Cant Get Enough", "https://open.spotify.com/track/3JA9Jsuxr4xgHXEawAdCp4?si=0a2c88af04a84e2b", "2:50", 5, TheBlackEyePeas);

        Song song5 = new Song("Forgot About Dre", "https://open.spotify.com/track/7iXF2W9vKmDoGAhlHdpyIa?si=769bb965b50c40fe", "3:42", 4, DrDre);

        Song song6 = new Song("Rap God", "https://open.spotify.com/track/6or1bKJiZ06IlK0vFvY75k?si=80fc7b9b3e824004", "6:03", 5, Eminem);

        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
        songRepo.save(song4);
        songRepo.save(song5);
        songRepo.save(song6);


    }
}
