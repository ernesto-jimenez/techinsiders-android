package com.espressocollective.techinsiders.home.domain.interactor.model;

import java.util.Date;

/**
 *
 */
public class Interview {
    public final static Interview EMPTY = new Interview();

    private static final int SHORT_DESCRIPTION_SIZE = 100;
    private String title = "";
    private String urlAvatar = "";
    private String body = "";
    private Date date;
    private String id = "";
    private String description;

    public Interview() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShortDescription() {
        int size = (description.length() > SHORT_DESCRIPTION_SIZE) ? SHORT_DESCRIPTION_SIZE
                : description.length();
        return description.substring(0, size);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
