package com.espressocollective.techinsiders.details.view.viewModel;

/**
 *
 */
public class InterviewCompleteViewModel {

    private String body = "";
    private String title = "";

    public InterviewCompleteViewModel(String title, String body) {
        this.body = body;
        this.title = title;
    }

    public String getTitle() { return title; }

    public String getBody() {
        return body;
    }
}
