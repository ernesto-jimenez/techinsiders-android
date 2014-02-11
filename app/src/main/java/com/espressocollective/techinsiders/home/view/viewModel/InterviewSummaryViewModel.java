package com.espressocollective.techinsiders.home.view.viewModel;

/**
 *
 */
public class InterviewSummaryViewModel {
    private String avatarUrl;
    private String title;
    private String summary;
    private String date;

    public InterviewSummaryViewModel(String avatarUrl, String title, String summary, String date) {
        this.avatarUrl = avatarUrl;
        this.title = title;
        this.summary = summary;
        this.date = date;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getDate() {
        return date;
    }
}
