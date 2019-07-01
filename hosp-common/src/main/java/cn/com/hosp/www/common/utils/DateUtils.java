package cn.com.hosp.www.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description Date类型 格式化处理类
 * @Author tome
 * @Date 19-6-28 下午9:46
 * @Version 1.0
 */

public class DateUtils {

    public static DateTimeFormatter defaultDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter defaultTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static DateTimeFormatter defaultDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    /**
     * 格式化日期时间
     * @param temporal  可以是LocalDateTime, LocalDate以及LocalTime等常用日期时间类
     * @param formatter  格式器
     * @return
     */
    public static String formatDate(TemporalAccessor temporal, DateTimeFormatter formatter) {
        return formatter.format(temporal);
    }

    /**
     * 使用默认格式解析日期时间  <br/>
     * localDate格式为 yyyy-MM-dd  <br/>
     * localTime格式为 HH:mm:ss <br/>
     * localDateTime格式为 yyyy-MM-dd HH:mm:ss <br/>
     * @param temporalAccessor  可以是LocalDateTime, LocalDate以及LocalTime等常用日期时间类
     * @return
     */
    public static String defaultFormat(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDate) {
            return formatDate(temporalAccessor, defaultDateFormat);
        }
        if (temporalAccessor instanceof LocalTime) {
            return formatDate(temporalAccessor, defaultTimeFormat);
        }
        if (temporalAccessor instanceof LocalDateTime) {
            return formatDate(temporalAccessor, defaultDateTimeFormatter);
        }
        return null;
    }

    /**
     * 格式化日期时间
     * @param temporal  可以是LocalDateTime, LocalDate以及LocalTime等常用日期时间类
     * @param pattern   yyyy:年 MM:月 dd:日 HH:小时 mm:分钟 ss:秒
     * @return
     */
    public static String formatDate(TemporalAccessor temporal, String pattern) {
        return formatDate(temporal, DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * 默认解析字符串日期时间
     * @param dateTime
     * @return
     */
    public static LocalDateTime defaultParse(String dateTime) {
        return LocalDateTime.parse(dateTime, defaultDateTimeFormatter);
    }

}
