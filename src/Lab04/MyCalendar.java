package Lab04;

import java.util.GregorianCalendar;

/*
* Testcase
* Correctness
* */

public class MyCalendar {
    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println("Current year, month, day, and day of week");
        System.out.println("Year is "+calendar.get(GregorianCalendar.YEAR));
        System.out.println("Month is "+calendar.get(GregorianCalendar.MONTH));
        System.out.println("Day is "+calendar.get(GregorianCalendar.DATE));
        System.out.println("Day of week is "+calendar.get(GregorianCalendar.DAY_OF_WEEK));

        final int DAY_MILLIS = 24*60*60*1000;
        calendar.setTimeInMillis(calendar.getTimeInMillis() + DAY_MILLIS);
        System.out.println("---------------------------------------");
        System.out.println("After specified the elapsed time of one day after current day");
        System.out.println("Year is "+calendar.get(GregorianCalendar.YEAR));
        System.out.println("Month is "+calendar.get(GregorianCalendar.MONTH));
        System.out.println("Day is "+calendar.get(GregorianCalendar.DATE));
        System.out.println("Day of week is"+calendar.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println(calendar.getTime());
    }
}
