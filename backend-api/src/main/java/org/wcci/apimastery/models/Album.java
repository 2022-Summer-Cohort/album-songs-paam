package org.wcci.apimastery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Set;

@Entity
public class Album {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String imgUrl;
    @OneToMany(mappedBy = "songs")
    private Collection<Song> songs;
    private String recordLabel;
    private String comments;
    private int ratings;

    public Album(String title, String imgUrl, String recordLabel, String comments, int ratings, Song...songs) {
        this.title = title;
        this.imgUrl = imgUrl;
        this.songs = Set.of(songs);
        this.recordLabel = recordLabel;
        this.comments = comments;
        this.ratings = ratings;
    }

    public Album() {
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

    public String getComments() {
        return comments;
    }

    public int getRatings() {
        return ratings;
    }
}
