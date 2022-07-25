package org.wcci.apimastery.controllers;


import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.models.Album;
import org.wcci.apimastery.models.Song;
import org.wcci.apimastery.repos.AlbumRepository;
import org.wcci.apimastery.repos.SongRepository;

import java.util.ArrayList;

@RestController
@RequestMapping()
public class AlbumController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("/api/albums")
    public Iterable<Album> retrieveAllAlbums() {
        return albumRepo.findAll();
    }

    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable Long id) {
        return albumRepo.findById(id).get();
    }
    @PostMapping("/api/albums/{id}/addSong")
    public Album addSongToAlbum(@PathVariable Long id, @RequestBody Song song) {
        Album album = albumRepo.findById(id).get();
        song.setAlbum(album);
        songRepo.save(song);
        return album;
    }

    @PostMapping("/api/albums")
    public Iterable<Album> addAlbum(@RequestBody Album albumToAdd) {
        albumRepo.save(albumToAdd);
        return albumRepo.findAll();
    }

    @PutMapping("/api/albums")
    public Iterable<Album> editAlbum(@RequestBody Album albumToEdit) {
        if (albumToEdit.getId() != null) {
            Album albumToChange = albumRepo.findById(albumToEdit.getId()).get();
            ArrayList<Song> songs = (ArrayList)albumToChange.getSongs();
            for (int i = 0; i < songs.size();i++) {
                songs.get(i).changeAlbum(albumToEdit);
                songRepo.save(songs.get(i));
            }
        }
        return albumRepo.findAll();
    }

    @PatchMapping("/api/albums/{id}/title")
    public Album albumToChangeTitle(@RequestBody String newTitle, @PathVariable Long id) {
        Album albumToChange = albumRepo.findById(id).get();
        albumToChange.changeTitle(newTitle);
        albumRepo.save(albumToChange);
        return albumToChange;
    }

    @DeleteMapping("/api/albums/{id}")
    public Iterable<Album> deleteAlbumById(@PathVariable Long id) {
        albumRepo.deleteById(id);
        return albumRepo.findAll();
    }

    @PatchMapping("/api/albums/{id}")
    public Iterable<Album> changeTitle(@PathVariable Long id, @RequestBody String title) {
        Album album = albumRepo.findById(id).get();
        album.changeTitle(title);
        albumRepo.save(album);
        return albumRepo.findAll();
    }
}
