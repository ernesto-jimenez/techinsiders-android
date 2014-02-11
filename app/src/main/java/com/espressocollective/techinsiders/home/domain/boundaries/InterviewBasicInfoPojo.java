package com.espressocollective.techinsiders.home.domain.boundaries;

/**
 *
 */
public class InterviewBasicInfoPojo {
    private String title;
    private String avatarUrl;
    private String smallDescription;

    public InterviewBasicInfoPojo(String title, String avatarUrl, String smallDescription) {
        this.title = title;
        this.avatarUrl = avatarUrl;
        this.smallDescription = smallDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getSmallDescription() {
        return smallDescription;
    }
}
