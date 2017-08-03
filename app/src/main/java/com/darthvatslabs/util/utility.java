package com.darthvatslabs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Vatsalya on 03-Aug-17.
 */

public class utility {
    public String getCurrentDay()
    {
        Date currentDateTimeString = new Date();
        SimpleDateFormat currentDayString = new SimpleDateFormat("EEEE");
        String dayOfTheWeek = currentDayString.format(currentDateTimeString);
        return dayOfTheWeek;
    }
};
