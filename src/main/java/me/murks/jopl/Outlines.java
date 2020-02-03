package me.murks.jopl;

import java.util.Date;
import java.util.List;

public class Outlines {
    private final String title;
    private final Date dateCreated;
    private final List<OpOutline> outlines;

    public Outlines(String newTitle, Date newDateCreated, List<OpOutline> newOutlines) {
        title = newTitle;
        dateCreated = newDateCreated;
        outlines = newOutlines;
    }

    public Outlines(OpFile opml) {
        this(opml.getHeader().getTitle(), opml.getHeader().getDateCreated(), opml.getBody().getOutlines());
    }

    public String getTitle() {
        return title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public List<OpOutline> getOutlines() {
        return outlines;
    }

    public OpFile getOpFile() {
        return new OpFile(new OpHeader(title, dateCreated), new OpBody(outlines));
    }
}
