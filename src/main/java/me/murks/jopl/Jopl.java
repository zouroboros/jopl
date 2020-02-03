package me.murks.jopl;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.text.ParseException;

/**
 * Main entry point for the jopl library. This provides easy access to almost all functionality of the jopl library.
 */
public class Jopl {

    /**
     * Parses the content of the given string into an {@link me.murks.jopl.Outlines} object.
     * @param str The input to parse.
     * @return A {@link me.murks.jopl.Outlines} object.
     * @throws IOException Exception in case the input could not be parsed.
     */
    public static Outlines outlines(String str) throws IOException {
        return outlines(new StringReader(str));
    }

    /**
     * Parses the content of the given stream into an {@link me.murks.jopl.Outlines} object.
     * @param input The input to parse.
     * @return A {@link me.murks.jopl.Outlines} object.
     * @throws IOException Exception in case the input could not be parsed.
     */
    public static Outlines outlines(InputStream input) throws IOException {
        try {
            XmlPullParser parser = parser();
            parser.setInput(input, null);
            OpFile file = new OpReader().readFile(parser);
            return new Outlines(file);
        } catch (XmlPullParserException|ParseException|IOException e) {
            throw new IOException("Error while parseing opml content.", e);
        }
    }

    /**
     * Parses the content of the given reader into an {@link me.murks.jopl.Outlines} object.
     * @param input The input to parse.
     * @return A {@link me.murks.jopl.Outlines} object.
     * @throws IOException Exception in case the input could not be parsed.
     */
    public static Outlines outlines(Reader input) throws IOException {
        try {
            XmlPullParser parser = parser();
            parser.setInput(input);
            OpFile file = new OpReader().readFile(parser);
            return new Outlines(file);
        } catch (XmlPullParserException|ParseException|IOException e) {
            throw new IOException("Error while parseing opml content.", e);
        }
    }

    private static XmlPullParser parser() throws XmlPullParserException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        return factory.newPullParser();
    }
}
