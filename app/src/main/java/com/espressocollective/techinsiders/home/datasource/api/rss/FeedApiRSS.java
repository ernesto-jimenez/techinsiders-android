package com.espressocollective.techinsiders.home.datasource.api.rss;

import com.espressocollective.techinsiders.home.datasource.api.FeedApi;
import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nl.matshofman.saxrssreader.RssFeed;
import nl.matshofman.saxrssreader.RssItem;
import nl.matshofman.saxrssreader.RssReader;

/**
 *
 */
public class FeedApiRSS implements FeedApi {
    private final RssReader reader;
    private final static String URL_FEED = "http://techinsiders.io/feed.xml";

    @Inject
    public FeedApiRSS(RssReader reader) {
        this.reader = reader;
    }

    @Override
    public List<FeedInterview> getFeed(int from, int to) {
        List<FeedInterview> allInterviews = new ArrayList<FeedInterview>();
        try {

            RssFeed feed = reader.read(new URL(URL_FEED));

            FeedInterview feedInterview = new FeedInterview();

            List<RssItem> rssItems = feed.getRssItems();
            for (RssItem rssItem : rssItems) {
                feedInterview.setTitle(rssItem.getTitle());
                feedInterview.setDescription(rssItem.getDescription());
                feedInterview.setContext(rssItem.getContent());
                feedInterview.setDate(rssItem.getPubDate());
                feedInterview.setId(rssItem.getLink());

                allInterviews.add(feedInterview);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allInterviews;
    }
}
