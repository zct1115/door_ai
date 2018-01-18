package com.zct.door_ai.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String getCurrentTime(){
        String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        return time;
    }
}
