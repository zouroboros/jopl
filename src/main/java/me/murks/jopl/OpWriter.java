package me.murks.jopl;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.Writer;

public class OpWriter {
    private XmlSerializer serializer;

    public void write(OpFile file, XmlSerializer output) throws IOException {
        serializer = output;
        serializer.startDocument("UTF-8", false);
        serializer.startTag(null, OpmlSymbols.Opml.toString());
        serializer.attribute(null, OpmlSymbols.Version.toString(), "2.0");

        if(file.getHeader() != null) {
            serializer.startTag(null, OpmlSymbols.Head.toString());

            if(file.getHeader().getTitle() != null) {
                serializer.startTag(null, OpmlSymbols.Title.toString());
                writeString(file.getHeader().getTitle());
                serializer.endTag(null, OpmlSymbols.Title.toString());
            }

            if(file.getHeader().getDateCreated() != null) {
                serializer.startTag(null, OpmlSymbols.DateCreated.toString());
                serializer.text(RFC822.formatDate(file.getHeader().getDateCreated()));
                serializer.endTag(null, OpmlSymbols.DateCreated.toString());
            }

            serializer.endTag(null, OpmlSymbols.Head.toString());
        }
        if(file.getBody() != null) {
            serializer.startTag(null, OpmlSymbols.Body.toString());
            for (OpOutline outline: file.getBody().getOutlines()) {
                serializer.startTag(null, OpmlSymbols.Outline.toString());
                if(outline.getTitle() != null) {
                    serializer.attribute(null, OpmlSymbols.Title.toString(), outline.getTitle());
                }

                if(outline.getText() != null) {
                    serializer.attribute(null, OpmlSymbols.Text.toString(), outline.getText());
                }

                if(outline.getType() != null) {
                    serializer.attribute(null, OpmlSymbols.Type.toString(), outline.getType());
                }

                if(outline.getXmlUrl() != null) {
                    serializer.attribute(null, OpmlSymbols.XmlUrl.toString(), outline.getXmlUrl().toString());
                }

                if(outline.getHtmlUrl() != null) {
                    serializer.attribute(null, OpmlSymbols.HtmlUrl.toString(), outline.getHtmlUrl().toString());
                }

                serializer.endTag(null, OpmlSymbols.Outline.toString());
            }
            serializer.endTag(null, OpmlSymbols.Body.toString());
        }

        serializer.endTag(null, OpmlSymbols.Opml.toString());
        serializer.endDocument();
    }

    private void writeString(String str) throws IOException {
        if(str != null) {
            serializer.text(str);
        }
    }
}
