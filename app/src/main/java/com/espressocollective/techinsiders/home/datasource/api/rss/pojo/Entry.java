package com.espressocollective.techinsiders.home.datasource.api.rss.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
*
*/
@Root(strict=false)
public class Entry {

    @Element
    private String id;
    @Element
    private String logo;
    @Element
    private String title;
    @Element
    private String published;
    @Element
    private String content;
    @Element
    private String summary;


    public String getId() {
        return id;
    }

    public String getLogo() {
        return logo;
    }

    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }

    public String getContent() {
        return content;
    }

    public String getSummary() {
        return summary;
    }
}
