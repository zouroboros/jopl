package me.murks.jopl;

public enum OpmlSymbols {
    Opml("opml"),
    Head("head"),
    Body("body"),
    Outline("outline"),
    Title("title"),
    Text("text"),
    Type("type"),
    XmlUrl("xmlUrl"),
    HtmlUrl("htmlUrl"),
    Version("version"),
    DateCreated("dateCreated");

    private final String symbol;

    OpmlSymbols(String newSymbol) {
        symbol = newSymbol;
    }

    public boolean isTag(String tag) {
        return symbol.equals(tag);
    }

    public String toString() {
        return symbol;
    }
}
