package com.espressocollective.techinsiders.home.datasource.api.rss.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Vector;

/**
 *
 */
@Root(strict=false)
public class Feed {
    @Element
    private String title;

    @ElementList(inline=true)
    private Vector<Entry> entry = new Vector<Entry>();

    public String getTitle() {
        return title;
    }

    public Vector<Entry> getEntry() {
        return entry;
    }

}
