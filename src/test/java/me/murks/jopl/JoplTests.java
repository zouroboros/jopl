package me.murks.jopl;

import org.junit.Assert;
import org.junit.Test;
import org.kxml2.io.KXmlSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class JoplTests {

    @Test
    public void testOutlinesFromString() throws IOException {
        Outlines outlines = Jopl.outlines(TestFiles.titleTest);
        Assert.assertEquals("Test Title", outlines.getTitle());
    }

    @Test
    public void testOutlinesFromReader() throws IOException {
        Outlines outlines = Jopl.outlines(new StringReader(TestFiles.titleTest));
        Assert.assertEquals("Test Title", outlines.getTitle());
    }

    @Test
    public void testOutlinesFromStream() throws IOException {
        Outlines outlines = Jopl.outlines(new ByteArrayInputStream(TestFiles.titleTest.getBytes()));
        Assert.assertEquals("Test Title", outlines.getTitle());
    }

    @Test
    public void testStringFromOutlines() throws IOException {
        Assert.assertEquals(TestFiles.outlineTest, Jopl.write(TestFiles.outlineTestOutlines, new KXmlSerializer()));
    }

    @Test
    public void testOutputStreamFromOutlines() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Jopl.write(TestFiles.outlineTestOutlines, output, new KXmlSerializer());
        Assert.assertEquals(TestFiles.outlineTest, new String(output.toByteArray(), StandardCharsets.UTF_8));
    }
}
