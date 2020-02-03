package me.murks.jopl;

/**
 * Enum containing all tag and attributes names of a OPML document.
 */
enum OpmlSymbols {
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

    /**
     * Checks weather the given string is the name of the current tag or attribute
     * @param tag The tag name to check
     * @return True if the given name if equal to the tag or attribute
     */
    public boolean isTag(String tag) {
        return symbol.equals(tag);
    }

    /**
     * How the symbol appears in an OPML document.
     * @return
     */
    public String toString() {
        return symbol;
    }
}
