package me.murks.jopl;

import java.text.ParseException;
import java.util.Date;

/***
 * Parser for unix time stamps.
 */
public class UnixTimeParser implements IDateParser {

    @Override
    public Date parseDate(String stringToParse) throws ParseException {
        try {
            return new Date(Long.parseLong(stringToParse));
        } catch (NumberFormatException e) {
            throw new ParseException(stringToParse, 0);
        }
    }
}
