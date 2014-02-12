package com.espressocollective.techinsiders.details.domain.boundaries;

/**
 *
 */
public class FullInterviewPojo {
    private String body;
    private String title;

    public FullInterviewPojo(String title, String body) {
        this.body = body;
        this.title = title;
    }

    public String getTitle() { return title; }

    public String getBody() {
        return body;
    }
}
