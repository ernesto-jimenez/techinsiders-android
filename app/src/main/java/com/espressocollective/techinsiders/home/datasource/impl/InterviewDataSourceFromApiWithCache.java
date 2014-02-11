package com.espressocollective.techinsiders.home.datasource.impl;

import com.espressocollective.techinsiders.home.datasource.InterviewDataSource;
import com.espressocollective.techinsiders.home.datasource.api.FeedApi;
import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;
import com.espressocollective.techinsiders.home.datasource.api.rss.mapper.MapperFeedApi;
import com.espressocollective.techinsiders.home.domain.interactor.model.Interview;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 *
 */
public class InterviewDataSourceFromApiWithCache implements InterviewDataSource {


    private final FeedApi feedApi;
    private final MapperFeedApi mapperFeedApi;

    @Inject
    public InterviewDataSourceFromApiWithCache(FeedApi feedApi, MapperFeedApi mapperFeedApi) {
        this.feedApi = feedApi;
        this.mapperFeedApi = mapperFeedApi;
    }

    @Override
    public List<Interview> getInterviews(int from, int to) {

        List<FeedInterview> feedInterviews = feedApi.getFeed(from, to);
        List<Interview> interviews = new ArrayList<Interview>();

        for (FeedInterview feedInterview : feedInterviews) {
            Interview interview = mapperFeedApi.toInterview(feedInterview);
            interviews.add(interview);
        }

        return interviews;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
