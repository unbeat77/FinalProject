import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DateToString{
    public static void main(String[] args) {
        Date d1 = new Date();

        SimpleDateFormat sdf =
                                new SimpleDateFormat("dd/MM/YYYY");
        sdf.setLenient(false);
        String date = sdf.format(d1);
        System.out.println(date);

        SimpleDateFormat sdf2 = new SimpleDateFormat(
            "E dd MMM yyyy 'at' hh:mm:ss a zzz"
        );

        sdf2.setLenient(false);
        String date2 = sdf2.format(d1);
        System.out.println(date2);

    }
}