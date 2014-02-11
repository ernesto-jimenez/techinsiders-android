package com.espressocollective.techinsiders.home.datasource.api.model;

import java.util.Date;

/**
 *
 */
public class FeedInterview {
    public final static FeedInterview EMPTY = new FeedInterview();
    private String title;
    private String description;
    private String context;
    private Date date;

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

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
