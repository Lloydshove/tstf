package com.lucasia.tstf.jester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: lucasia
 */
public class JesterApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/spring-context.xml");

    }
}
