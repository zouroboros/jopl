package me.murks.jopl;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

    /**
     * Writes the OPML markup of the given {@link Outlines} into a string.
     * @param outlines The outlines to write.
     * @param serializer The xml serializer to use.
     * @return String containing OPML markup.
     * @throws IOException In case the writing fails.
     */
    public static String write(Outlines outlines, XmlSerializer serializer) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        serializer.setOutput(output, null);
        new OpWriter().write(outlines.getOpFile(), serializer);
        return new String(output.toByteArray(), StandardCharsets.UTF_8);
    }

    /**
     * Writes the OPML markup of the given {@link Outlines} in an output stream.
     * @param outlines The outlines to write.
     * @param output The output stream to write on.
     * @param serializer The xml serializer to use.
     * @throws IOException In case the writing fails.
     */
    public static void write(Outlines outlines, OutputStream output, XmlSerializer serializer) throws IOException {
        serializer.setOutput(output, null);
        new OpWriter().write(outlines.getOpFile(), serializer);
    }
}
