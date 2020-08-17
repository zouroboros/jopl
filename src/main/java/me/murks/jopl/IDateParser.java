package me.murks.jopl;

import java.text.ParseException;
import java.util.Date;

/***
 * Interfaces for parser that can parse dates from strings.
 */
public interface IDateParser {

    /***
     * Parse a string into a date.
     * @param stringToParse The string to parse.
     * @return The parsed string.
     * @throws ParseException Exception indicating that the string could not be parsed.
     */
    Date parseDate(String stringToParse) throws ParseException;
}
