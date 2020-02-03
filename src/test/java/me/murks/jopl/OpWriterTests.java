package me.murks.jopl;

import org.junit.Assert;
import org.junit.Test;
import org.kxml2.io.KXmlSerializer;
import org.xmlpull.v1.XmlSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class OpWriterTests {

    @Test
    public void testTitle() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        XmlSerializer serializer = new KXmlSerializer();
        serializer.setOutput(output, null);
        new OpWriter().write(TestFiles.titleTestOutlines.getOpFile(), serializer);
        output.close();
        String str = new String(output.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals(TestFiles.titleTest, str);
    }

    @Test
    public void testDateCreated() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        XmlSerializer serializer = new KXmlSerializer();
        serializer.setOutput(output, null);
        new OpWriter().write(TestFiles.dateCreatedOutlines.getOpFile(), serializer);
        output.close();
        String str = new String(output.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals(TestFiles.dateCreatedTest, str);
    }

    @Test
    public void testOutline() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        XmlSerializer serializer = new KXmlSerializer();
        serializer.setOutput(output, null);
        new OpWriter().write(TestFiles.outlineTestOutlines.getOpFile(), serializer);
        output.close();
        String str = new String(output.toByteArray(), StandardCharsets.UTF_8);
        Assert.assertEquals(TestFiles.outlineTest, str);
    }
}
