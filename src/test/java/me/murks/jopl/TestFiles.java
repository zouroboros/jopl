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

    public static Outlines outlineTestOutlines = new Outlines(null, null,
                                                            Arrays.asList(new OpOutline("Outline Text", "Outline Title", "test",
                                                                    "http://example.org/xml", "http://example.org/html")));

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

    public static final String invalidUrl = "<?xml version='1.0' encoding='UTF-8' standalone='no' ?>\n" +
            "<opml version=\"2.0\">\n" +
            "<body>\n"+
            "    <outline text=\"Classic Lenses Podcast\" title=\"Classic Lenses Podcast\" type=\"rss\" xmlUrl=\"https://classiclensespodcast.podbean.com/feed.xml\" htmlUrl=\"https://classiclensespodcast.podbean.com&lt;itunes:new-feed-url&gt;\" />\n"+
            "  </body>\n"+
            "</opml>";

    public static final String unixTime = "<?xml version='1.0' encoding='utf-8'?>\n" +
            "<opml version='1.1'>\n" +
            "<head>\n" +
            "<title>spaRSS export</title>\n" +
            "<dateCreated>1591992760121</dateCreated>\n" +
            "</head>\n" +
            "<body>\n" +
            "</body>\n" +
            "</opml>";

    public static final String spaRssBackupFile = "<?xml version='1.0' encoding='utf-8'?>\n" +
            "<opml version='1.1'>\n" +
            "<head>\n" +
            "<title>spaRSS export</title>\n" +
            "<dateCreated>1591992760121</dateCreated>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<outline title='CrowdScience' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p04d42rc.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='BadmintonWorld.tv' type='rss' xmlUrl='https://www.youtube.com/feeds/videos.xml?user=bwf' retrieveFullText='true'/>\n" +
            "\t<outline title='Click' type='rss' xmlUrl='http://podcasts.files.bbci.co.uk/p002w6r2.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='TED Radio Hour' type='rss' xmlUrl='https://www.npr.org/rss/podcast.php?id=510298' retrieveFullText='true'/>\n" +
            "\t<outline title='HARDtalk' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p004t1s0.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='Live In Concert from NPR&#39;s All Songs Considered' type='rss' xmlUrl='https://www.npr.org/rss/podcast.php?id=510253' retrieveFullText='true'/>\n" +
            "\t<outline title='Future Shock VPRO Tegenlicht' type='rss' xmlUrl='https://rs.vpro.nl/v3/api/feeds/podcast/POMS_S_VPRO_11660029?podtrac=true' retrieveFullText='true'/>\n" +
            "\t<outline title='Zembla podcast' type='rss' xmlUrl='https://podcast.npo.nl/feed/zembla-podcast.xml' retrieveFullText='true'/>\n" +
            "\t<outline title='The Documentary Podcast' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p02nq0lx.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='Piano Jazz Shorts' type='rss' xmlUrl='https://www.npr.org/rss/podcast.php?id=510056' retrieveFullText='true'/>\n" +
            "\t<outline title='Tiny Desk Concerts - Audio' type='rss' xmlUrl='https://www.npr.org/rss/podcast.php?id=510306' retrieveFullText='true'/>\n" +
            "\t<outline title='Global News Podcast' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p02nq0gn.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='The TED Interview' type='rss' xmlUrl='http://feeds.feedburner.com/TedInterview' retrieveFullText='true'/>\n" +
            "\t<outline title='The Inquiry' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p029399x.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='VPRO Zomergasten' type='rss' xmlUrl='http://podcast.npo.nl/feed/zomergasten.xml' retrieveFullText='true'/>\n" +
            "\t<outline title='How To Fail With Elizabeth Day' type='rss' xmlUrl='https://feed.podbean.com/howtofail/feed.xml' retrieveFullText='true'/>\n" +
            "\t<outline title='The Dissenter' type='rss' xmlUrl='https://anchor.fm/s/822ba20/podcast/rss' retrieveFullText='true'/>\n" +
            "\t<outline title='Nieuws RIVM' type='rss' xmlUrl='https://www.rivm.nl/nieuws/rss.xml' retrieveFullText='true'/>\n" +
            "\t<outline title='The Numberphile Podcast' type='rss' xmlUrl='https://www.numberphile.com/podcast?format=RSS' retrieveFullText='true'/>\n" +
            "\t<outline title='TED Talks Daily' type='rss' xmlUrl='http://feeds.feedburner.com/tedtalks_audio' retrieveFullText='true'/>\n" +
            "\t<outline title='The Dispatch Podcast' type='rss' xmlUrl='https://thedispatch.sounder.fm/show/aLn9D/rss.xml' retrieveFullText='true'/>\n" +
            "\t<outline title='GitLab System Status' type='rss' xmlUrl='https://status.gitlab.com/pages/5b36dc6502d06804c08349f7/rss' retrieveFullText='true'/>\n" +
            "\t<outline title='Digital Planet' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/p002w6r2.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='The Infinite Monkey Cage' type='rss' xmlUrl='https://podcasts.files.bbci.co.uk/b00snr0w.rss' retrieveFullText='true'/>\n" +
            "\t<outline title='Hidden Brain' type='rss' xmlUrl='https://www.npr.org/rss/podcast.php?id=510308' retrieveFullText='true'/>\n" +
            "\t<outline title='Echt Gebeurd' type='rss' xmlUrl='https://rss.art19.com/echt-gebeurd' retrieveFullText='true'/>\n" +
            "\t<outline title='Reggae Moods Podcast' type='rss' xmlUrl='https://reggaemoods.podomatic.com/rss2.xml' retrieveFullText='true'/>\n" +
            "</body>\n" +
            "</opml>";
}
