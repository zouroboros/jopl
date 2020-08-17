package me.murks.jopl;

import org.junit.Assert;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

public class OpReaderTests {

    @Test
    public void testTitle() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.titleTest));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals("Test Title", file.getHeader().getTitle());
    }

    @Test
    public void testDateCreated() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.dateCreatedTest));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals(new Date(1580584261000L), file.getHeader().getDateCreated());
    }

    @Test
    public void testOutline() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.outlineTest));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertArrayEquals(Arrays.asList(new OpOutline("Outline Text", "Outline Title",
                "test", "http://example.org/xml", "http://example.org/html")).toArray(),
                file.getBody().getOutlines().toArray());
    }

    @Test
    public void testAntennaPodFile() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.antennaPodFile));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals("AntennaPod Subscriptions", file.getHeader().getTitle());
        Assert.assertEquals(new Date(1580584261000l), file.getHeader().getDateCreated());
    }

    @Test
    public void testInvalidUrl() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.invalidUrl));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals("Invalid Url",
                "https://classiclensespodcast.podbean.com<itunes:new-feed-url>",
                file.getBody().getOutlines().get(0).getHtmlUrl());
    }

    @Test
    public void unixTimeParseing() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.unixTime));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals(new Date(1591992760121l), file.getHeader().getDateCreated());
    }

    @Test
    public void testSpaRss() throws XmlPullParserException, IOException, ParseException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(TestFiles.spaRssBackupFile));
        OpFile file = new OpReader().readFile(parser);
        Assert.assertEquals("spaRSS export", file.getHeader().getTitle());
        Assert.assertEquals(new Date(1591992760121l), file.getHeader().getDateCreated());
    }
}
