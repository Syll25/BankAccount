package syll25.BankAccount;

import org.example.Timestamp;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeStampTest {

    @Test
    public void getDate() {
        String timeZone = "Asia/Tokyo";
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(timeZone));

        Timestamp timestamp = new Timestamp(
                timeZone,
                now.getYear(),
                now.getMonthValue(),
                now.getDayOfMonth(),
                now.getHour(),
                now.getMinute(),
                now.getSecond(),
                now.getNano() / 1_000_000
        );

        ZonedDateTime expectedUtcDateTime = now.withZoneSameInstant(ZoneId.of("UTC"));
        DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS");

        assertEquals(expectedUtcDateTime.format(timestampFormatter), timestamp.getTimestamp());
    }

    @Test
    public void getTimestamp() {
        String timeZone = "Europe/Warsaw";
        int year = 2024;
        int month = 7;
        int day = 3;
        int hour = 12;
        int minute = 0;
        int second = 0;
        int millisecond = 0;

        Timestamp timestamp = new Timestamp(timeZone, year, month, day, hour, minute, second, millisecond);
        String expectedTimestamp = "2024/07/03 10:00:00.000";
        assertEquals(expectedTimestamp, timestamp.getTimestamp());
    }

    @Test
    public void getTimestampForGermany() {
        String timeZone = "Europe/Berlin";
        int year = 2024;
        int month = 7;
        int day = 3;
        int hour = 12;
        int minute = 0;
        int second = 0;
        int millisecond = 0;

        Timestamp timestamp = new Timestamp(timeZone, year, month, day, hour, minute, second, millisecond);
        String expectedTimestamp = "2024/07/03 10:00:00.000";
        assertEquals(expectedTimestamp, timestamp.getTimestamp());
    }
}
