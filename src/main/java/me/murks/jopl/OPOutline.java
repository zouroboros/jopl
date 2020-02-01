package me.murks.jopl;

public class OPOutline {
    private final String text;
    private final String title;
    private final String type;
    private final String xmlUrl;
    private final String htmlUrl;

    public OPOutline(String newText, String newTitle, String newType, String newXmlUrl, String newHtmlUrl) {
        text = newText;
        title = newTitle;
        type = newType;
        xmlUrl = newXmlUrl;
        htmlUrl = newHtmlUrl;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getXmlUrl() {
        return xmlUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }
}
