package me.murks.jopl;

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
