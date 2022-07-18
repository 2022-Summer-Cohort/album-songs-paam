package org.wcci.apimastery.model;

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
}
