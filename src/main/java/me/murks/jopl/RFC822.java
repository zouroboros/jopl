package me.murks.jopl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class for working with RFC822 formatted dates.
 */
class RFC822 implements IDateParser {
    public Date parseDate(String string) throws ParseException {

        // replace nonstandard time zone identifier
        String str = string.replace("UT", "UTC").replace("Z", "UTC");

        List<SimpleDateFormat> formats = Arrays.asList(new SimpleDateFormat("EEE, dd MMM yy HH:mm:ss z", Locale.US),
                new SimpleDateFormat("EEE, dd MMM yy HH:mm Z"),
                new SimpleDateFormat("EEE, dd MMM yy HH:mm z"),
                new SimpleDateFormat("dd MMM yy HH:mm:ss z"),
                new SimpleDateFormat("dd MMM yy HH:mm z"));

        for (SimpleDateFormat format: formats) {
            try {
                return format.parse(str.trim());
            } catch (ParseException e) { }
        }

        throw new ParseException(str, 0);
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yy HH:mm:ss Z", Locale.US);
        return format.format(date);
    }
}
