package sirma.academy.employeepairs.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateFormatParser {
    public static LocalDate parse(String dateStr) {

        LocalDate parsedDate = null;

        for (String format : Constants.DATE_FORMATS) {
            try {
                DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .append(DateTimeFormatter.ofPattern(format).withLocale(Locale.US))
                        .toFormatter();

                parsedDate = LocalDate.parse(dateStr, formatter);
                break;
            } catch (DateTimeParseException ignored) {

            }
        }

        if (parsedDate == null) {
            System.out.println(Constants.DATE_PARSE_ERR + dateStr);
            System.exit(1);
        }

        return parsedDate;
    }
}
