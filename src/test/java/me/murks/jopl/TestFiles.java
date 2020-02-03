package me.murks.jopl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class TestFiles {

    public static final Outlines titleTestOutlines = new Outlines("Test Title", null, Collections.emptyList());
    public static final String titleTest = "<?xml version='1.0' encoding='UTF-8' standalone='no' ?><opml version=\"2.0\"><head><title>Test Title</title></head><body /></opml>";

    public static final Outlines dateCreatedOutlines = new Outlines(null, new Date(1580584261000L), Collections.emptyList());
    public static final String dateCreatedTest = "<?xml version='1.0' encoding='UTF-8' standalone='no' ?><opml version=\"2.0\"><head><dateCreated>" +
            RFC822.formatDate(new Date(1580584261000L)) + "</dateCreated></head><body /></opml>";

    public static Outlines outlineTestOutlines;

    static {
        try {
            outlineTestOutlines = new Outlines(null, null,
                        Arrays.asList(new OpOutline("Outline Text", "Outline Title", "test",
                                new URL("http://example.org/xml"), new URL("http://example.org/html"))));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String outlineTest = "<?xml version='1.0' encoding='UTF-8' standalone='no' ?><opml version=\"2.0\"><head /><body>" +
            "<outline title=\"Outline Title\" text=\"Outline Text\" type=\"test\" xmlUrl=\"http://example.org/xml\" htmlUrl=\"http://example.org/html\" />" +
            "</body></opml>";

    public static final String antennaPodFile = "<?xml version='1.0' encoding='UTF-8' standalone='no' ?>\n" +
            "<opml version=\"2.0\">\n" +
            "  <head>\n" +
            "    <title>AntennaPod Subscriptions</title>\n" +
            "    <dateCreated>01 Feb 20 20:11:01 +0100</dateCreated>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <outline text=\"99% Invisible\" title=\"99% Invisible\" type=\"rss\" xmlUrl=\"http://feeds.99percentinvisible.org/99percentinvisible\" htmlUrl=\"http://99percentinvisible.org\" />\n" +
            "    <outline text=\"Analog Talk\" title=\"Analog Talk\" type=\"rss\" xmlUrl=\"https://api.podcache.net/shows/92bf9085-a91e-49f6-81b8-5b651b52ba3f/feed\" htmlUrl=\"https://redcircle.com/shows/analog-talk\" />\n" +
            "    <outline text=\"Duolingo Spanish Podcast\" title=\"Duolingo Spanish Podcast\" type=\"rss\" xmlUrl=\"http://spanishpodcast.duolingo.libsynpro.com/rss\" htmlUrl=\"https://podcast.duolingo.com/spanish\" />\n" +
            "    <outline text=\"Ear Hustle\" title=\"Ear Hustle\" type=\"rss\" xmlUrl=\"http://feeds.earhustlesq.com/earhustlesq\" htmlUrl=\"https://www.earhustlesq.com/\" />\n" +
            "    <outline text=\"Radiolab\" title=\"Radiolab\" type=\"rss\" xmlUrl=\"http://feeds.wnyc.org/radiolab\" htmlUrl=\"https://www.wnycstudios.org/podcasts/radiolab/projects/podcasts\" />\n" +
            "    <outline text=\"Software Engineering Daily\" title=\"Software Engineering Daily\" type=\"rss\" xmlUrl=\"http://softwareengineeringdaily.com/feed/podcast/\" htmlUrl=\"http://softwareengineeringdaily.com/archives/\" />\n" +
            "    <outline text=\"Studio C-41: 1 Hour Photo Podcast\" title=\"Studio C-41: 1 Hour Photo Podcast\" type=\"rss\" xmlUrl=\"http://studioc41.libsyn.com/rss\" htmlUrl=\"http://www.studioc41.net\" />\n" +
            "    <outline text=\"That Creative Life\" title=\"That Creative Life\" type=\"rss\" xmlUrl=\"https://feeds.simplecast.com/TotMkT_g\" htmlUrl=\"https://www.youtube.com/thatcreativelife\" />\n" +
            "    <outline text=\"The Haskell Cast\" title=\"The Haskell Cast\" type=\"rss\" xmlUrl=\"http://www.haskellcast.com/feed.xml\" htmlUrl=\"http://www.haskellcast.com\" />\n" +
            "    <outline text=\"The Kodakery\" title=\"The Kodakery\" type=\"rss\" xmlUrl=\"http://feeds.soundcloud.com/users/soundcloud:users:190739215/sounds.rss\" htmlUrl=\"http://soundcloud.com/the-kodakery\" />\n" +
            "    <outline text=\"This American Life\" title=\"This American Life\" type=\"rss\" xmlUrl=\"http://feed.thisamericanlife.org/talpodcast\" htmlUrl=\"https://www.thisamericanlife.org\" />\n" +
            "  </body>\n" +
            "</opml>";
}
