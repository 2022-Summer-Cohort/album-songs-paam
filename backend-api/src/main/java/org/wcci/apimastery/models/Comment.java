package org.wcci.apimastery.models;

import javax.persistence.Embeddable;

@Embeddable
public class Comment {

    private String userName;
    private String comment;

    public Comment(String userName, String comment) {
        this.userName = userName;
        this.comment = comment;
    }

    public Comment() {
    }

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }
}
