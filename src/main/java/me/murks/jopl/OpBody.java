package me.murks.jopl;

import java.util.List;

/**
 * Container for the body of a OPML document. The body contains a list of outlines.
 */
public class OpBody {
    private final List<OpOutline> outlines;

    public OpBody(List<OpOutline> newOutlines) {
        outlines = newOutlines;
    }

    /**
     * List of outlines that are contained in the OPML file.
     */
    public List<OpOutline> getOutlines() {
        return outlines;
    }
}
