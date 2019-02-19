package com.beamuae.availablehotels.utilities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatUtils {

    public static String dateIsoInstant(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        return DateTimeFormatter.ISO_INSTANT.format(instant);
    }

    public static String dateIsoLocalDate(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

}
