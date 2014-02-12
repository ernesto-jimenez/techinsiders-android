package com.espressocollective.techinsiders.home.datasource.api.rss.mapper;

import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;

/**
 *
 */
public class MapperFeedApi {
    public Interview toInterview(FeedInterview feedInterview) {
        Interview interview = new Interview();
        interview.setBody(feedInterview.getDescription());
        interview.setDate(feedInterview.getDate());
        interview.setTitle(feedInterview.getTitle());
        interview.setUrlAvatar(null);
        interview.setId(feedInterview.getId());

        return interview;
    }
}
