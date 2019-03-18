
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TodayDate{
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = now.format(format);
        System.out.println(formatDateTime);
    }
}