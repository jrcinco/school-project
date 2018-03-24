
package com.school.web.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Manage date
 * @author jhonny
 */
public class DateUtil {
    /**
     * The timestamp format is <year><month><day><hour><minute><second>
     * @return String
     */
    public static String getTodayTimestamp() {
        Date date = new Date(); // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        String monthStr = (month > 9)? ""+month: "0"+month;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String dayStr = (day > 9)? ""+day: "0"+day;
        int hour = cal.get(Calendar.HOUR);
        String hourStr = (hour > 9)? ""+hour: "0"+hour;
        int minute = cal.get(Calendar.MINUTE);
        String minuteStr = (minute > 9)? ""+minute: "0"+minute;
        int second = cal.get(Calendar.SECOND);
        String secondStr = (second > 9)? ""+second: "0"+second;
               
        return year+monthStr+dayStr+hourStr+minuteStr+secondStr;
    }
}
