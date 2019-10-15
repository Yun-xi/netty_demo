package com.xxxx.netty.bytebuf;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-07-18 11:37
 */
public class AtomicUpdaterTest {

    public static void main(String[] args) {
        /*Person person = new Person();

        for (int i = 0; i < 10; ++i ) {
            Thread thread = new Thread(() -> {
                System.out.println(person.age++);
            });

            thread.start();
        }*/
        /**
         * 1
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         */

        Person person = new Person();
        AtomicIntegerFieldUpdater<Person> atomicIntegerFieldUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Person.class, "age");
        for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(() -> {
                System.out.println(atomicIntegerFieldUpdater.getAndIncrement(person));
            });

            thread.start();
        }
    }
}

class Person {
    volatile int age = 1;
}
