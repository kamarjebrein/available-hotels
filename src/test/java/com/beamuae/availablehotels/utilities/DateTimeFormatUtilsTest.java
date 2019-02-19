package com.beamuae.availablehotels.utilities;

import org.junit.Test;

import static com.beamuae.availablehotels.TestConstants.*;
import static org.junit.Assert.assertEquals;

public class DateTimeFormatUtilsTest {

    @Test
    public void whenGivenLocalDateReturnFormattedStringWithISOInstant() {
        String dateIsoInstant = DateTimeFormatUtils.dateIsoInstant(FEB_19_2019);
        assertEquals(FEB_19_2019_ISO_INSTANT, dateIsoInstant);
    }

    @Test
    public void whenGivenLocalDateReturnFormattedStringWithISOLocalDate() {
        String dateIsoLocalDate = DateTimeFormatUtils.dateIsoLocalDate(FEB_19_2019);
        assertEquals(FEB_19_2019_ISO_LOCAL_DATE, dateIsoLocalDate);
    }
}