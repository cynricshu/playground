// Copyright (C) 2018 Baidu Inc. All rights reserved.

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Main
 *
 * @author Shu Lingjie(shulingjie@baidu.com)
 */
public class Guava {
    public static void main(String[] args) {
        Integer.parseInt("1");

        System.out.println(32 & 0);

        Set<String> receivers = new HashSet<>();
        receivers.add("shulingjie@baidu.com");
        receivers.add("jiangjunchao@baidu.com");
        String[] a = receivers.toArray(new String[]{});

        Stream.of(1, 2, 3).forEach(it -> {
            return;
        });

        System.out.println("hello");

        double years = 1.51;
        String yearStr = new DecimalFormat("#.#").format(years);
        System.out.println(years);
        System.out.println(yearStr);
    }
}
