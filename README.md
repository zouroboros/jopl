# jopl - A lightweight pure Java OPML parser

[![Release](https://jitpack.io/v/zouroboros/jopl.svg)](https://jitpack.io/#zouroboros/jopl)

The Outline Processor Markup Language (OPML) is an XML based format that is 
commonly used in RSS/Atom feed readers for importing and exporting a list of
feeds. The original specification can be found [here](http://dev.opml.org/).

An OPML file consist of a header which contains metadata such as a title and 
a creation date. The actual content is contained in the body of an OPML file.
The body of an OPML file is a list of several outlines each consisting of a
title, text, type, http url, and a xml url.

The jopl library provides a simple interface for reading and writing OPML files.
Under the hood jopl uses the [xmlpull](http://www.xmlpull.org) API for working with
XML files. This makes jopl particular suited for Android apps. You can use jopl as 
a maven package via [jitpack.io](https://jitpack.io/#zouroboros/jopl).

In most cases the `Jopl` class provides a simple interface for reading and writing
OPML files.

The following snippet shows how to read an OPML file into an Outlines object.
```
Reader reader = FileReader("example.opml");
Outlines outlines = Jopl.outlines(reader);
```
The outlines object has getters which allow accessing the informations contained
in the head and body sections.
```
outlines.getTitle(); // the title of the OPML file.
outlines.getDateCreated(); // returns the creation date of the OPML file.
```

The list of outlines can be accessed via the `getOutlinesMethod`.

```
List<OpOutlines> outlinesList = outlines.getOutlines();
```

Outlines can also be created from scratch.
```
String title = "Outlines created via code";
Date creationDate = new Date();
List<OpOutline> outlinesList = new LinkedList<OpOutline>();
outlinesList.add(new OpOutline("Outline title", "Outline text", "outlinetype",
    "https://example.org/xmlUrl", "https://example.org/httpUrl"));
Outlines outlines = new Outlines(title, creationDate, outlinesList);
```

Existing `Outlines` objects can be written to files via the `write` methods in
the `Jopl` class.
```
FileOutputStream outputStream = new FileOutputStream("test.opml");
XmlSerializer xmlSerializer = ...;
Outlines outlines = ...;
Jopl.write(outlines, outputStream, xmlSerializer);
```