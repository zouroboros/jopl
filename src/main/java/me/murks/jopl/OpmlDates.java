package me.murks.jopl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/***
 * Utility functions for working with dates from an OPML file.
 */
public class OpmlDates {

    /***
     * Tries to parse a string into a date.
     * @param stringToParse String to parse.
     * @return The parsed date.
     * @throws ParseException Exception when the string could not be parsed.
     */
    public static Date parseDate(String stringToParse) throws ParseException {
        Collection<IDateParser> dateParsers = Arrays.asList(new RFC822(), new UnixTimeParser());

        for (IDateParser dateParser : dateParsers) {
            try {
                return dateParser.parseDate(stringToParse);
            } catch (ParseException e) {
            }
        }

        throw new ParseException(stringToParse, 0);
    }
}
