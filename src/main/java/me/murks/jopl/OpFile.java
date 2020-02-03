package me.murks.jopl;
/**
 * Class that represents a complete OPML document/file. A OPML document is divided into two sections. 1. A header that
 * contains metadata and a body that mainly consists of a list of outlines.
 */
public class OpFile {
    private final OpHeader header;
    private final OpBody body;

    public OpFile(OpHeader newHeader, OpBody newBody) {
        header = newHeader;
        body = newBody;
    }

    public OpHeader getHeader() {
        return header;
    }

    public OpBody getBody() {
        return body;
    }
}
