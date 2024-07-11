package org.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {
    private ZonedDateTime dateTime;

    public Timestamp(String timeZone, int year, int month, int day, int hour, int minute, int second, int millisecond) {
        this.dateTime = ZonedDateTime.of(year, month, day, hour, minute, second, millisecond * 1_000_000, ZoneId.of(timeZone));
    }

    public String getDate() {
        ZonedDateTime utcDateTime = dateTime.withZoneSameInstant(ZoneId.of("UTC"));
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return utcDateTime.format(dateFormatter);
    }

    public String getTimestamp() {
        ZonedDateTime utcDateTime = dateTime.withZoneSameInstant(ZoneId.of("UTC"));
        DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");
        return utcDateTime.format(timestampFormatter);
    }

}