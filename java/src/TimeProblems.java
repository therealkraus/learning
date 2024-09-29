import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public class TimeProblems {
    public static int countFridayThirteens(LocalDate start, LocalDate end){
        return Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                .filter(date -> date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .mapToInt(date -> 1)
                .sum();
    }

    public static String dayAfterSeconds(LocalDateTime timeHere, long seconds) {
        return timeHere.plusSeconds(seconds).getDayOfWeek().toString();
    }

    public static int whatHourIsItThere(LocalDateTime timeHere, String here, String there) {
        ZoneId hereZone = ZoneId.of(here);
        ZoneId thereZone = ZoneId.of(there);
        return timeHere.atZone(hereZone).withZoneSameInstant(thereZone).getHour();
    }
}
