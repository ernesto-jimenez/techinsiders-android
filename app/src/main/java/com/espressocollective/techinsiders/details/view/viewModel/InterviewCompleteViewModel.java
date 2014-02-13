package com.espressocollective.techinsiders.details.view.viewModel;

/**
 *
 */
public class InterviewCompleteViewModel {

    private String body = "";
    private String title = "";
    private String url = "";

    public InterviewCompleteViewModel(String title, String body, String url) {
        this.body = body;
        this.title = title;
        this.url = url;
    }

    public String getTitle() { return title; }

    public String getBody() { return body; }

    public String getUrl() {
        return url;
    }
}
