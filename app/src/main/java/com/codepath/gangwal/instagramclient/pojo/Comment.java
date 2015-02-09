package com.codepath.gangwal.instagramclient.pojo;

/**
 * Created by gangwal on 2/8/15.
 */
public class Comment {

    String username;
    String commentText;

    public Comment(String username, String commentText) {
        this.username = username;
        this.commentText = commentText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }


    @Override
    public String toString() {
        return "<b>"
                + username +
                "</b> '" + commentText;
    }
}
