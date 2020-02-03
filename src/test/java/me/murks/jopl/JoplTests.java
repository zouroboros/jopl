package me.murks.jopl;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

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
}
