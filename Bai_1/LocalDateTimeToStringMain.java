
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToStringMain {
    public static void main(String[] args) {
        System.out.println("Total day: " + calculateTotalDay("20170220", "20211224"));
        System.out.println("close date: " + calculateDate("20170228", 1));
    }

    public static long calculateTotalDay(String startDate, String endDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        long result = 0;
        try {
            // convert date string to date object
            LocalDateTime date1 = LocalDate.parse(startDate, dtf).atStartOfDay();
            LocalDateTime date2 = LocalDate.parse(endDate, dtf).atStartOfDay();
            // caculate days between 2 date
            result = Duration.between(date1, date2).toDays();
        } catch (Exception ignored) {
        }
        return result;
    }

    public static String calculateDate(String startDate, int bonusMonths) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        try {
            LocalDateTime convertedStartDate = LocalDate.parse(startDate, dtf).atStartOfDay();
            LocalDateTime endDate = convertedStartDate.plusMonths(bonusMonths);
            return endDate.format(dtf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}