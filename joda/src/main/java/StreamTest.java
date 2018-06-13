// Copyright (C) 2018 Baidu Inc. All rights reserved.

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Lambda
 *
 * @author shulingjie(shulingjie @ baidu.com)
 */
public class StreamTest {

    public static void main(String[] args) {
        // 在stream中修改某个element的值，输出后就是修改后的值
        List<A> a = Stream.of(new A())
                .peek(it -> it.setA("bbb"))
                .collect(Collectors.toList());

        a.forEach(it -> {
            it.setA("asdfasdf");
        });

        System.out.println(a.get(0).getA());

    }

    static class A {
        String a = "a";

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }
    }
}
