package com.espressocollective.techinsiders.home.domain.boundaries;

/**
 *
 */
public class InterviewBasicInfoPojo {
    private final String idInterview;
    private String title;
    private String avatarUrl;
    private String smallDescription;

    public InterviewBasicInfoPojo(String title, String avatarUrl, String smallDescription,
                                  String id) {
        this.title = title;
        this.avatarUrl = avatarUrl;
        this.smallDescription = smallDescription;
        this.idInterview = id;
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

    public String getIdInterview() {
        return idInterview;
    }
}
