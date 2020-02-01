package me.murks.jopl;

public class OPFile {
    private final OPHeader header;
    private final OPBody body;

    public OPFile(OPHeader newHeader, OPBody newBody) {
        header = newHeader;
        body = newBody;
    }

    public OPHeader getHeader() {
        return header;
    }

    public OPBody getBody() {
        return body;
    }
}
