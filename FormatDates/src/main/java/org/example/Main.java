package org.example;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();

        System.out.println("---- GMT Time ----");
        DateTimeFormatter date1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date1today = today.format(date1);
        DateTimeFormatter date2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date2today = today.format(date2);
        DateTimeFormatter date3 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String date3today = today.format(date3);
        DateTimeFormatter date4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        String date4today = today.format(date4);

        System.out.println(date1today);
        System.out.println(date2today);
        System.out.println(date3today);
        System.out.println(date4today);


        DateTimeFormatter timeDate = DateTimeFormatter.ofPattern("HH:mm");
        String time = today.format(timeDate);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String todayDate = today.format(date);
        System.out.println("\n---- Challenge ---- \n" + time + " on " + todayDate );



    }
}