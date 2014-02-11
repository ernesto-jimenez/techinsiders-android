package com.espressocollective.techinsiders.home.domain.interactor.model;

import java.util.Date;

/**
 *
 */
public class Interview {
    private static final int SHORT_DESCRIPTION_SIZE = 100;
    private String title = "";
    private String urlAvatar = "";
    private String body = "";
    private Date date;

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
        int size = (body.length() > SHORT_DESCRIPTION_SIZE) ? SHORT_DESCRIPTION_SIZE : body
                .length();
        return body.substring(0, size);
    }
}
