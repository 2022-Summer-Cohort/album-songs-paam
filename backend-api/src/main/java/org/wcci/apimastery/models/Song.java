package org.wcci.apimastery.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Song {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String link;
    private String duration;

    private int ratings;

    @ElementCollection
    private Collection<Comment> comments;

    @ManyToOne
    @JsonIgnore
    private Album album;

    public Song(String title, String link, String duration, int ratings, Album album) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.comments = new ArrayList<>();
        this.ratings = ratings;
        this.album = album;
    }

    public Song() {
    }

    public Collection<Comment>getComments() {
        return comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
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
