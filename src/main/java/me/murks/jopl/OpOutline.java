package me.murks.jopl;

import java.net.URL;
import java.util.Objects;

/**
 * Represents one outline node in a OPML document.
 */
public class OpOutline {
    private final String text;
    private final String title;
    private final String type;
    private final String xmlUrl;
    private final String htmlUrl;

    public OpOutline(String newText, String newTitle, String newType, String newXmlUrl, String newHtmlUrl) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpOutline opOutline = (OpOutline) o;
        return Objects.equals(text, opOutline.text) &&
                Objects.equals(title, opOutline.title) &&
                Objects.equals(type, opOutline.type) &&
                Objects.equals(xmlUrl, opOutline.xmlUrl) &&
                Objects.equals(htmlUrl, opOutline.htmlUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, title, type, xmlUrl, htmlUrl);
    }

    @Override
    public String toString() {
        return "OpOutline{" +
                "text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", xmlUrl='" + xmlUrl + '\'' +
                ", htmlUrl='" + htmlUrl + '\'' +
                '}';
    }
}
