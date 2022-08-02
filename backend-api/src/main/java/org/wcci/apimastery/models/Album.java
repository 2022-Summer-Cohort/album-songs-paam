package org.wcci.apimastery.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String imgUrl;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL,orphanRemoval = true)
    private Collection<Song> songs;
    private String recordLabel;
    private int ratings;

    @ElementCollection
    private Collection<Comment> comments;

    public Album(String title, String imgUrl, String recordLabel, int ratings, Song...songs) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.songs = Set.of(songs);
        this.recordLabel = recordLabel;
        this.comments = new ArrayList<>();
        this.ratings = ratings;
    }

    public Album() {
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public String getRecordLabel() {
        return recordLabel;
    }


    public int getRatings() {
        return ratings;
    }

    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    public void changeRecordLabel(String newRecordLabel) {
        recordLabel = newRecordLabel;
    }

}
