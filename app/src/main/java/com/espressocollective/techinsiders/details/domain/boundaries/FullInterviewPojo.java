package com.espressocollective.techinsiders.details.domain.boundaries;

/**
 *
 */
public class FullInterviewPojo {
    private String body;
    private String title;
    private String url;

    public FullInterviewPojo(String title, String body, String url) {
        this.body = body;
        this.title = title;
        this.url = url;
    }

    public String getTitle() { return title; }

    public String getBody() { return body; }
    public String getUrl() { return url; }
}
