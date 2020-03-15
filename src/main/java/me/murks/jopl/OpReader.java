package me.murks.jopl;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Reads a OPML document into an {@link OpFile}.
 */
public class OpReader {

    private String title;
    private Date dateCreated;
    private List<OpOutline> outlines;

    /**
     * Reads the file using the given xml parser.
     * @param parser
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     * @throws ParseException
     */
    public OpFile readFile(XmlPullParser parser) throws XmlPullParserException, IOException, ParseException {
        int eventType = parser.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (OpmlSymbols.Head.isTag(parser.getName())) {
                        parseHead(parser);
                    } else if (OpmlSymbols.Body.isTag(parser.getName())) {
                        parseBody(parser);
                    }
            }
            eventType = parser.next();
        }

        return new OpFile(new OpHeader(title, dateCreated), new OpBody(outlines));
    }

    private void parseHead(XmlPullParser parser) throws XmlPullParserException, IOException, ParseException {
        int eventType = parser.getEventType();
        while(!(eventType == XmlPullParser.END_TAG && OpmlSymbols.Head.isTag(parser.getName()))) {
            if(eventType == XmlPullParser.START_TAG) {
                if(OpmlSymbols.Title.isTag(parser.getName())) {
                    title = parser.nextText();
                } else if(OpmlSymbols.DateCreated.isTag(parser.getName())) {
                    dateCreated = RFC822.readDate(parser.nextText());
                }

            }
            eventType = parser.next();
        }
    }

    private void parseBody(XmlPullParser parser) throws XmlPullParserException, IOException {
        outlines = new LinkedList<>();
        int eventType = parser.getEventType();
        while(!(eventType == XmlPullParser.END_TAG && OpmlSymbols.Body.isTag(parser.getName()))) {
            if(eventType == XmlPullParser.START_TAG && OpmlSymbols.Outline.isTag(parser.getName())) {
                String title = parser.getAttributeValue(null, OpmlSymbols.Title.toString());
                String text = parser.getAttributeValue(null, OpmlSymbols.Text.toString());
                String type = parser.getAttributeValue(null, OpmlSymbols.Type.toString());
                String htmlUrl = parser.getAttributeValue(null, OpmlSymbols.HtmlUrl.toString());
                String xmlUrl = parser.getAttributeValue(null, OpmlSymbols.XmlUrl.toString());
                outlines.add(new OpOutline(text, title, type, xmlUrl, htmlUrl));
            }
            eventType = parser.next();
        }
    }
}
