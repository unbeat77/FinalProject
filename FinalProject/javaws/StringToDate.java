import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class StringToDate{
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf =
                                new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        sdf.setLenient(false);
        String date = "01/01/2019 10:02:22";
        Date d1 = sdf.parse(date);
        System.out.println(d1);
    }
}