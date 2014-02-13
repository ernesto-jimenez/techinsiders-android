package com.espressocollective.techinsiders.home.datasource.api.model;

import java.util.Date;

/**
 *
 */
public class FeedInterview {
    public final static FeedInterview EMPTY = new FeedInterview();
    private String title;
    private String description;
    private String content;
    private Date date;
    private String id;
    private String avatar;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }
}
