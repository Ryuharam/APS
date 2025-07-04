import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws Exception {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
}
