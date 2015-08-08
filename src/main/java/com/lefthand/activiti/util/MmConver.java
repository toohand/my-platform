package com.lefthand.activiti.util;

/**
 * 毫秒转工具  分：秒
 * Created by PanjinF on 2015/6/17.
 */
public class MmConver {
    public static String coverMm(int mm) {
        long hour = mm / (60 * 60 * 1000);
        long minute = (mm - hour * 60 * 60 * 1000) / (60 * 1000);
        long second = (mm - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;
        if (second >= 60) {
            second = second % 60;
            minute += second / 60;
        }
        if (minute >= 60) {
            minute = minute % 60;
            hour += minute / 60;
        }
        String sh = "";
        String sm = "";
        String ss = "";
        if (hour < 10) {
            sh = "0" + String.valueOf(hour);
        } else {
            sh = String.valueOf(hour);
        }
        if (minute < 10) {
            sm = "0" + String.valueOf(minute);
        } else {
            sm = String.valueOf(minute);
        }
        if (second < 10) {
            ss = "0" + String.valueOf(second);
        } else {
            ss = String.valueOf(second);
        }
        String ms = sh + "时" + sm + "分" + ss + "秒";
        return ms;
    }
}
