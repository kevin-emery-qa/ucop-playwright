package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {
    public static String dateTimeString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(new Date());
    }
}
