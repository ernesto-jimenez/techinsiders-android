package com.espressocollective.techinsiders.home.datasource;

import com.espressocollective.techinsiders.home.datasource.api.FeedApi;
import com.espressocollective.techinsiders.home.datasource.api.rss.FeedApiRSS;
import com.espressocollective.techinsiders.home.datasource.api.rss.mapper.MapperFeedApi;
import com.espressocollective.techinsiders.home.datasource.impl.InterviewDataSourceFromApiWithCache;

import java.net.URL;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nl.matshofman.saxrssreader.RssFeed;
import nl.matshofman.saxrssreader.RssReader;

/**
 *
 */
@Module(complete = false,
        library = true)
public class HomeDataSourceModule {


    @Provides
    @Singleton
    public InterviewDataSource provideInterviewDataSource(InterviewDataSourceFromApiWithCache
                                                           interviewDataSourceFromApiWithCache){
        return interviewDataSourceFromApiWithCache;
    }

    @Provides
    public FeedApi provideFeedApi(FeedApiRSS feedApi){
        return feedApi;
    }

    @Provides
    @Singleton
    public RssReader provideRssReader(){
        return new RssReader();
    }

    @Provides
    public MapperFeedApi provideMapperFeedApi(){
        return new MapperFeedApi();
    }

}

