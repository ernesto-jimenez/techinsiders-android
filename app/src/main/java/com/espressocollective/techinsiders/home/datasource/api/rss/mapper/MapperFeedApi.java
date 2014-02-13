package com.espressocollective.techinsiders.home.datasource.api.rss.mapper;

import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;

/**
 *
 */
public class MapperFeedApi {
    public Interview toInterview(FeedInterview feedInterview) {
        Interview interview = new Interview();
        interview.setDescription(feedInterview.getDescription());
        interview.setBody(feedInterview.getContent());
        interview.setDate(feedInterview.getDate());
        interview.setTitle(feedInterview.getTitle());
        interview.setUrlAvatar(feedInterview.getAvatar());
        interview.setId(feedInterview.getId());

        return interview;
    }
}
