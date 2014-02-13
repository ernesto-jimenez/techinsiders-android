package com.espressocollective.techinsiders.home.datasource.api.rss;

import com.espressocollective.techinsiders.base.logger.LoggerProvider;
import com.espressocollective.techinsiders.home.datasource.api.FeedApi;
import com.espressocollective.techinsiders.home.datasource.api.model.FeedInterview;
import com.espressocollective.techinsiders.home.datasource.api.rss.pojo.Entry;
import com.espressocollective.techinsiders.home.datasource.api.rss.pojo.Feed;
import com.squareup.okhttp.OkHttpClient;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


/**
 *
 */
public class FeedApiRSS implements FeedApi {

    //private final RssReader reader;
    private final static String URL_FEED = "http://staging.techinsiders.io/atom.xml";
    private static final String LOGTAG = "FeedApiRSS";

    OkHttpClient client = new OkHttpClient();

    @Inject
    public FeedApiRSS() {
        //this.reader = reader;
    }

    @Override
    public List<FeedInterview> getFeed(int from, int to) {
        List<FeedInterview> allInterviews = new ArrayList<FeedInterview>();

        Serializer serializer = new Persister();

        Feed feed = null;

        try {
            String body = get(new URL(URL_FEED));
            feed = serializer.read(Feed.class, body);

        } catch (Exception e) {
            LoggerProvider.getLogger().e(LOGTAG, "error parsing atom", e);
            e.printStackTrace();
        }


        FeedInterview feedInterview = new FeedInterview();

        List<Entry> entries = feed.getEntry();
        for (Entry entry : entries) {
            feedInterview.setTitle(entry.getTitle());
            feedInterview.setDescription(entry.getSummary());
            feedInterview.setContent(entry.getContent());
            feedInterview.setDate(null);
            feedInterview.setId(entry.getId());
            feedInterview.setAvatar(entry.getLogo());
            feedInterview.setUrl(entry.getId());

            allInterviews.add(feedInterview);
        }


        return allInterviews;
    }


    String get(URL url) throws IOException {
        HttpURLConnection connection = client.open(url);
        InputStream in = null;
        try {
            // Read the response.
            in = connection.getInputStream();
            byte[] response = readFully(in);
            return new String(response, "UTF-8");
        } finally {
            if (in != null) in.close();
        }
    }

    public final static int BUFFER_SIZE = 1024;
    private byte[] inputBuffer = new byte[BUFFER_SIZE];

    private byte[] readFully(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int charsRead;

        while ((charsRead = in.read(inputBuffer)) != -1) {
            baos.write(inputBuffer,0,charsRead);
        }

        return baos.toByteArray();
    }
}
