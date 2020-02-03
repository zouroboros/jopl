package me.murks.jopl;

import java.util.Date;

public class OpHeader {
    private final String title;
    private final Date dateCreated;

    public OpHeader(String newTitle, Date newDateCreated) {
        title = newTitle;
        dateCreated = newDateCreated;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
