package com.imooc.utils;


import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {
    public static String today() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }
    public static String format(Date date, String tpl) {
        SimpleDateFormat format = new SimpleDateFormat(tpl);
        return format.format(date);
    }

    /**
     * 任意一天的开始时间
     *
     * @return date
     */
    public static Date startOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date returnDate = calendar.getTime();
        return returnDate;
    }

    /**
     * 任意一天的结束时间
     *
     * @return date
     */
    public static Date endOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date returnDate = calendar.getTime();
        return returnDate;
    }

    /**
     * 获取时间戳的开始时间
     * zg
     * @param timestamp
     */
    public static Long startOfDayByTimestamp(Long timestamp) {
        Date date = new Date(timestamp);
        return startOfDay(date).getTime();
    }

    /**
     * 获取时间戳的结束时间
     * zg
     * @param timestamp
     */
    public static Long endOfDayByTimestamp(Long timestamp) {
        Date date = new Date(timestamp);
        return endOfDay(date).getTime();
    }

    /**
     * 当天的开始时间
     *
     * @return
     */
    public static Date startOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date;
    }
    /**
     * 当天的结束时间
     *
     * @return
     */
    public static Date endOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 昨天的开始时间
     *
     * @return
     */
    public static Date startOfyesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 昨天的结束时间
     *
     * @return
     */
    public static Date endOfyesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DATE, -1);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 功能：获取本周的开始时间 示例：2013-05-13 00:00:00
     */
    public static Date startOfThisWeek() {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date date = currentDate.getTime();
        return date;
    }

    /**
     * 功能：获取String日期对应的时间戳
     * format 格式自定
     *
     * @return
     */
    public static Long formatStringToStamp(String base, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date baseTime;
        Long stamp = null;
        try {
            baseTime = df.parse(base);
            stamp = baseTime.getTime();
        } catch (Exception e) {
            return null;
        }
        return stamp;
    }


    /**
     * 功能：获取String日期对应的时间
     * isTotal = false ;yyyy-MM-dd格式限定
     * isTotal = true ;yyyy-MM-dd hh-mm-ss格式限定
     */
    public static Date formatStringToDate(String base, Boolean isTotal) {
        String format = isTotal ? "yyyy-MM-dd hh-mm-ss" : "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(format);
        Date baseTime;
        try {
            baseTime = df.parse(base);
        } catch (Exception e) {
            return null;
        }
        return baseTime;
    }

    /**
     * 功能：获取本周的结束时间 示例：2013-05-19 23:59:59
     */
    public static Date endOfThisWeek() {// 当周结束时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.setFirstDayOfWeek(Calendar.MONDAY);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        currentDate.set(Calendar.MILLISECOND, 999);
        currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date date = currentDate.getTime();
        return date;
    }

    /**
     * 功能：获取本月的开始时间
     */
    public static Date startOfThisMonth() {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        Date date = currentDate.getTime();
        return date;
    }

    public static Date endOfThisMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return date;
    }

    /**
     * 功能：获取上月的开始时间
     */
    public static Date startOfLastMonth() {// 当周开始时间
        Calendar currentDate = Calendar.getInstance();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        currentDate.set(Calendar.DAY_OF_MONTH, 1);
        currentDate.add(Calendar.MONTH, -1);
        Date date = currentDate.getTime();
        return date;
    }

    /**
     * 功能：获取上月的结束时间
     */
    public static Date endOfLastMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        return date;
    }
    private static final int[] DAY_OF_MONTH = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd",
            "yyyy-MM", "yyyy-MM-dd HH:mm:ss.S", "yyyy年MM月dd日", "yyyy年MM月dd日 HH:mm", "yyyyMMdd", "yyyy年MM月dd日 HH:mm:ss",
            "MM.dd"};

    /**
     * 将传入的日期以指定格式转成字符串
     *
     * @param format
     * @param dt
     * @return
     */
    public static String formatDate(String format, Date dt) {
        if (dt == null) {
            return "";
        }
        if (format.isEmpty()) {
            format = "yyyy-MM-dd";
        }

        SimpleDateFormat fmt = new SimpleDateFormat(format);
        return fmt.format(dt);
    }

    /**
     * 将传入的日期转化为"yyyy-MM-dd"形式的字符串
     *
     * @param dt 日期
     * @return 指定日期格式的字符串
     */
    public static String formatDate(Date dt) {

        return formatDate("yyyy-MM-dd", dt);
    }
    /**
     * 将传入的日期转化为"yyyy-MM-dd HH:mm:ss"形式的字符串
     *
     * @param dt 日期
     * @return 指定日期格式的字符串
     */
    public static String formatDateYMDHMS(Date dt) {

        return formatDate("yyyy-MM-dd HH:mm:ss", dt);
    }

    /**
     * 将传入的日期转化为"yyyy-MM-dd HH:mm"形式的字符串
     *
     * @param dt 日期
     * @return 指定日期格式的字符串
     */
    public static String formatDateYMDHM(Date dt) {

        return formatDate("yyyy-MM-dd HH:mm", dt);
    }



    /**
     * 获取今天的日期
     *
     * @return
     */
    public static Date getToday() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 得到传入日期n天后的日期,如果传入日期为null，则表示当前日期n天后的日期
     *
     * @param Date dt 日期
     * @param days 可以为任何整数，负数表示前days天，正数表示后days天
     * @return Date
     */
    public static Date getAddDayDate(Date dt, int days) {
        Calendar cal = Calendar.getInstance();
        if (dt != null) {
            cal.setTime(dt);
        }
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 得到当前日期几天后（plusDays>0）or 几天前（plusDays<0）的指定格式的字符串日期
     *
     * @param dt
     * @param plusDays
     * @param dateFormat
     * @return
     */
    public static String getAddDayDateFromToday(int plusDays, String dateFormat) {
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DAY_OF_MONTH, plusDays);

        return formatDate(dateFormat, cal.getTime());
    }


    /**
     * 给定的时间再加上指定小时数,如果传入日期为null，能以当前时间计算
     *
     * @param dt
     * @param hours
     * @return
     * @author Alex Zhang
     */
    public static Date getAddHourDate(Date dt, int hours) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.HOUR, hours);

        return cal.getTime();
    }

    /**
     * 给定的时间再加上指定分钟数
     *
     * @param dt
     * @param minutes
     * @return
     * @author Alex Zhang
     */
    public static Date getAddMinuteDate(Date dt, int minutes) {
        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.MINUTE, minutes);

        return cal.getTime();
    }

    /**
     * 给定的时间再加上指定月份数
     *
     * @param dt
     * @param months
     * @return
     * @author wei suicun
     */
    public static Date getAddMonthDate(Date dt, int months) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.MONTH, months);

        return cal.getTime();
    }

    /**
     * 获得某天的零点时刻0:0:0
     *
     * @param date 日期
     * @return
     */
    public static Date getDayBegin(Date date) {

        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得某天的截至时刻23:59:59
     *
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {

        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 某月的起始时间,eg：param:2011-11-10 12:10:50.999, return：2011-11-1 00:00:00.000
     */
    public static Date getMonthBeginTime(Date dt) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 某月的截止时间,eg：param:2011-11-10 12:10:50.999, return：2011-11-30 23:59:59.999
     */
    public static Date getMonthEndTime(Date dt) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, -1);
        return cal.getTime();
    }

    /**
     * 获得传入日期的年\月\日,以整型数组方式返回
     *
     * @param dt
     * @return int[]
     */
    public static int[] getTimeArray(Date dt) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        int[] timeArray = new int[3];
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        timeArray[0] = cal.get(Calendar.YEAR);
        timeArray[1] = cal.get(Calendar.MONTH) + 1;
        timeArray[2] = cal.get(Calendar.DAY_OF_MONTH);
        return timeArray;
    }

    /**
     * 获得传入日期的年\月\日\小时\分,以整型数组方式返回
     *
     * @param dt
     * @return
     */
    public static int[] timeArray(Date dt) {

        if (dt == null)
            dt = new Date(System.currentTimeMillis());
        int[] timeArray = new int[5];
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        timeArray[0] = cal.get(Calendar.YEAR);
        timeArray[1] = cal.get(Calendar.MONTH) + 1;
        timeArray[2] = cal.get(Calendar.DAY_OF_MONTH);
        timeArray[3] = cal.get(Calendar.HOUR_OF_DAY);
        timeArray[4] = cal.get(Calendar.MINUTE);
        return timeArray;
    }

    /**
     * 根据年月日得到Date类型时间
     *
     * @param year
     * @param month
     * @param day
     * @return Date
     * @author Alan he <alan.he@jongogroup.com>
     */
    public static Date getTime(Integer year, Integer month, Integer day) {

        Calendar cal = Calendar.getInstance();
        if (year != null)
            cal.set(Calendar.YEAR, year);
        if (month != null)
            cal.set(Calendar.MONTH, month - 1);
        if (day != null)
            cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * @param parrern 格式化字符串 例如：yyyy-MM-dd
     * @param str     时间字符串 例如：2007-08-01
     * @return 出错返回null
     * @author kim <kim.qiu@jongogroup.com> 通过格式化字符串得到时间
     */
    public static Date getDateFromPattern(String parrern, String str) {
        SimpleDateFormat fmt = new SimpleDateFormat(parrern);
        try {
            return fmt.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 计算两个日期间相隔的小时
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return
     */
    public static int getHourBetween(Date d1, Date d2) {

        long m = d1.getTime();
        long n = d2.getTime();
        return (int) ((m - n) / 3600000);
    }

    /**
     * 取得两个时间之间的天数，可能是负数(第二个时间的日期小于第一个时间的日期)。如果两个时间在同一天，则返回0
     *
     * @param d1 第一个时间
     * @param d2 第二个时间
     * @return
     * @author Derek
     * @version 1.0 2009-10-14
     */
    public static int getDayBetween(Date d1, Date d2) {

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        return (int) ((c2.getTimeInMillis() - c1.getTimeInMillis()) / 86400000);
    }

    /**
     * 计算两个日期间相隔的秒数
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return
     */
    public static long getSecondBetweem(java.util.Date d1, java.util.Date d2) {

        return (d1.getTime() - d2.getTime()) / 1000;
    }

    /**
     * 计算两个日期间相隔的月份数
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return
     */
    public static int getMonthBetween(java.util.Date d1, java.util.Date d2) {

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        return (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12 + (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH));
    }

    /**
     * 通过生日得到当前年龄
     *
     * @param birthDay 以日期表示的生日
     * @return 返回以以字符串表示的年龄, 最小为0
     */
    public static String getAge(Date birthDate) {

        if (birthDate == null) {
            return "未知";
        }

        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDate)) {
            throw new IllegalArgumentException("The birthDay is before Now. It is unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDate);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                } else {
                }
            } else {
                age--;
            }
        } else {
        }
        return age + "";
    }

    @SuppressWarnings("deprecation")
    public static int getIntAge(Date brithday) {

        if (brithday != null) {
            int dateMiss = Calendar.getInstance().getTime().getDate() - brithday.getDate();// 日差距
            int monthMiss = Calendar.getInstance().getTime().getMonth() - brithday.getMonth();// 月份差距
            int yearMiss = Calendar.getInstance().getTime().getYear() - brithday.getYear();// 年份差距
            if (monthMiss > 0 || (monthMiss == 0 && dateMiss >= 0)) {
                return yearMiss;
            } else {
                return yearMiss - 1;// 周岁少两岁，SO在去掉一年
            }
        }
        return 0;
    }

    /**
     * 根据周几的数字标记获得周几的汉字描述
     */
    public static String getCnWeekDesc(int weekNum) {
        String strWeek = "";
        switch (weekNum) {
            case 1:
                strWeek = "周一";
                break;
            case 2:
                strWeek = "周二";
                break;
            case 3:
                strWeek = "周三";
                break;
            case 4:
                strWeek = "周四";
                break;
            case 5:
                strWeek = "周五";
                break;
            case 6:
                strWeek = "周六";
                break;
            case 7:
                strWeek = "周日";
                break;
        }
        return strWeek;
    }

    /**
     * 获得"上下午"标识
     *
     * @param date
     * @return
     */
    public static String getCnAMPM(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (Calendar.AM == cal.get(Calendar.AM_PM))
            return "上午";
        else
            return "下午";

    }

    /**
     * 判断两个日期是否相等
     *
     * @param d1 日期1
     * @param d2 日期2
     * @return
     */
    public static boolean isTimeEquals(Date d1, Date d2) {

        if (d1 == null || d2 == null)
            return false;
        return Math.abs(d1.getTime() - d2.getTime()) < 50;
    }

    /**
     * 获取一个日期的年份
     *
     * @param date 日期
     * @return
     */
    public static int getYear(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取一个日期的月份
     *
     * @param date 日期
     * @return
     */
    public static int getMonthOfYear(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    /**
     * 获取一个日期的天数
     *
     * @param date
     * @return
     */
    public static int getDay(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取一个日期的小时数
     *
     * @param date
     * @return
     */
    public static int getHour(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取一个日期的分钟
     *
     * @param date 日期
     * @return
     */
    public static int getMinute(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取一个日期的秒数
     *
     * @param date 日期
     * @return
     */
    public static int getSecond(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.SECOND);
    }

    /**
     * 获取一个月的最大天数
     *
     * @param year  年份
     * @param month 月份
     * @return
     */
    public static int getMaxDayOfMonth(int year, int month) {

        if (month == 1 && isLeapYear(year)) {
            return 29;
        }
        return DAY_OF_MONTH[month];
    }

    /**
     * 判断是否是润年
     *
     * @param year 年份
     * @return
     */
    public static boolean isLeapYear(int year) {

        Calendar calendar = Calendar.getInstance();
        return ((GregorianCalendar) calendar).isLeapYear(year);
    }

    /**
     * 得到本周的起始时间
     *
     * @param currentDate
     * @return
     */
    public static Date getBeginDateofThisWeek(Date currentDate) {
        Calendar current = Calendar.getInstance();
        current.setTime(currentDate);
        int dayOfWeek = current.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek == 1) { // 如果是星期天，星期一则往前退6天
            current.add(Calendar.DAY_OF_MONTH, -6);
        } else {
            current.add(Calendar.DAY_OF_MONTH, 2 - dayOfWeek);
        }

        current.set(Calendar.HOUR_OF_DAY, 0);
        current.set(Calendar.MINUTE, 0);
        current.set(Calendar.SECOND, 0);
        current.set(Calendar.MILLISECOND, 0);

        return current.getTime();
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Map<String, Date> map = getDateForWeekDay();
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    /**
     * 转化时间从指定格式日期为长整形
     *
     * @param format
     * @param time
     * @return
     */
    public static Long convertDateStringToDateLong(String format, String time) throws ParseException {
        if (time == null || time.trim().equals("")) {
            return null;
        }
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        Date d = fmt.parse(time);
        return d.getTime();
    }



    public static int getMinuteBetween(Date d1, Date d2) {
        if (d1 == null || d2 == null)
            return 0;
        long m = d1.getTime();
        long n = d2.getTime();
        return (int) ((m - n) / 60000);
    }

    /**
     * 计算创建时间到现在过去多久了
     *
     * @param createTime
     * @return
     */
    public static String getPastTime(Date createTime) {

        String pastTime;
        Date current = new Date();
        int days = getDayBetween(current, createTime);
        int hours = 0;
        int mins = 0;
        if (days > 0) {
            pastTime = "1天前";
        } else if ((hours = getHourBetween(current, createTime)) > 0) {
            pastTime = hours + "小时前";
        } else if ((mins = getMinuteBetween(current, createTime)) > 0) {
            pastTime = mins + "分钟前";
        } else {
            long seconds = getSecondBetweem(current, createTime);
            if (seconds > 5) {
                pastTime = seconds + "秒前";
            } else {
                pastTime = "刚刚";
            }
        }
        return pastTime;
    }

    /**
     * 获取从今天开始未来一周的星期和日期的映射表 1-星期一:2014-05-12，2-星期二:2014-05-13.....
     *
     * @return
     */
    public static Map<String, Date> getDateForWeekDay() {
        Map<String, Date> weekDayDateMap = new HashMap<String, Date>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= 7; i++) {
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (dayOfWeek == 0) {
                dayOfWeek = 7;
            }
            weekDayDateMap.put(dayOfWeek + "", calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return weekDayDateMap;
    }

    /**
     * 获得本日星期数,星期一:1,星期日:7 如果传入null则默认为本日
     *
     * @return
     */
    public static int getDayOfWeek(Calendar calendar) {
        int today;
        if (calendar != null) {
            today = calendar.get(Calendar.DAY_OF_WEEK);
        } else {
            today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        }
        if (today == 1)
            return 7;
        else
            return today - 1;
    }

    /**
     * 获取日期的中国式星期几（1-7分别代表周一至周日）
     *
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        if (date == null) {
            date = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayOfWeek(cal);
    }

    /**
     * 判断两个日期是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);

        if (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH)) {
            return true;
        }

        return false;
    }

    public static String formatDuration(long duration) {
        float secondUnit = 1000;
        String formatDuration = "";
        DecimalFormat decimalFormat = new DecimalFormat(".00");

        if (duration < secondUnit) {
            formatDuration = duration + "(毫秒)";
        } else if (duration < secondUnit * 60) {
            formatDuration = decimalFormat.format(duration / secondUnit) + "(秒)";
        } else if (duration < secondUnit * 3600) {
            formatDuration = decimalFormat.format(duration / (secondUnit * 60)) + "(分钟)";
        } else if (duration < secondUnit * 3600 * 60) {
            formatDuration = decimalFormat.format(duration / (secondUnit * 3600)) + "(小时)";
        } else {
            formatDuration = decimalFormat.format(duration / (secondUnit * 3600 * 24)) + "(天)";
        }

        return formatDuration;
    }

    public static long getTodayBeginTime() {
        return getDayBegin(new Date()).getTime();
    }

    public static long getTodayEndTime() {
        return getDayEnd(new Date()).getTime();
    }

    /**
     * 比较两个时间大小
     *
     * @param startTime
     * @param endTime
     * @return int
     * @method compareDate()
     */
    public static int compareDate(String startTime, String endTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(startTime);
        Date d2 = sdf.parse(endTime);
        return d1.compareTo(d2);
    }
}