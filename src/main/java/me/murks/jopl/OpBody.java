package me.murks.jopl;

import java.util.List;

public class OpBody {
    private final List<OpOutline> outlines;

    public OpBody(List<OpOutline> newOutlines) {
        outlines = newOutlines;
    }

    public List<OpOutline> getOutlines() {
        return outlines;
    }
}
