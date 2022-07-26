package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String link;
    private String duration;
    private String comment;
    private int ratings;

    @ManyToOne
    @JsonIgnore
    private Album album;

    public Song(String title, String link, String duration, String comment, int ratings, Album album) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comment = comment;
        this.ratings = ratings;
        this.album = album;
    }

    public Song() {
    }
    public void changeAlbum (Album newAlbum) {
        album = newAlbum;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDuration() {
        return duration;
    }

    public String getComment() {
        return comment;
    }

    public int getRatings() {
        return ratings;
    }

    public Album getAlbum() {
        return album;
    }
    public void changeTitle(String newTitle) {
        title = newTitle;
    }
    public void setAlbum(Album album) {
        this.album = album;
    }
}
