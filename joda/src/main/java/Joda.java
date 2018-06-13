// Copyright (C) 2017 Baidu Inc. All rights reserved.

import static org.joda.time.format.DateTimeFormat.forPattern;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormatter;

/**
 * Main
 *
 * @author shulingjie(shulingjie @ baidu.com)
 */
public class Joda {
    public static void main(String[] args) {

        System.out.println(new Duration(new DateTime("2014-07-05T00:00:00"), DateTime.now()));

        DateTime now = new DateTime(1514736000000L);
        System.out.println(now);
        System.out.println(now.toString("yyyy-M"));
        now = now.withDayOfMonth(1).withMillisOfDay(0);

        DateTime end = now.plusMonths(1).withDayOfMonth(1).withMillisOfDay(0);

        System.out.println(now.getMillis());
        System.out.println(end.getMillis());
        System.out.println(end.getMillis() - now.getMillis());
        DateTime utc = now.withZone(DateTimeZone.UTC);
        DateTime shanghai = now.withZone(DateTimeZone.forID("Asia/Shanghai"));

        System.out.println(now);
        System.out.println(now.toLocalDate());
        System.out.println(utc.getMillis());
        System.out.println(shanghai.getMillis());

        /**
         * 不论有没有最后三位毫秒，都能正确的parse
         */
        String utcStr1 = "2018-03-26T10:00:52.628Z";
        String utcStr2 = "2018-03-26T10:00:52Z";
        System.out.println(DateTime.parse(utcStr1));
        System.out.println(DateTime.parse(utcStr2));

        String dateStr = "2017-12-01 08:00:00";
        DateTimeFormatter utcFormatter = forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.UTC);
        DateTimeFormatter shanghaiFormatter = forPattern("yyyy-MM-dd HH:mm:ss").withZone(
                DateTimeZone.forID("+08:00"));
        System.out.println(utcFormatter.parseDateTime(dateStr));
        System.out.println(shanghaiFormatter.parseDateTime(dateStr).withZone(DateTimeZone.UTC));

    }
}
