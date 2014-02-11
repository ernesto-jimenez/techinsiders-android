package com.espressocollective.techinsiders.home.datasource.api;

import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;

import java.util.List;

/**
 *
 */
public interface FeedApi {

    public List<FeedInterview> getFeed(int from, int to);
}
