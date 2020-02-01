package me.murks.jopl;

import java.util.Calendar;

public class OPHeader {
    private final String title;
    private final Calendar dateCreated;

    public OPHeader(String newTitle, Calendar newDateCreated) {
        title = newTitle;
        dateCreated = newDateCreated;
    }

    public String getTitle() {
        return title;
    }

    public Calendar getDateCreated() {
        return dateCreated;
    }
}
