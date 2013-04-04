package com.lucasia.tstf.jester.providers.marklogic;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * User: lucasia
 */
@Component
public class MarkLogic {
    private String user;
    private String password;

    public MarkLogic(String user, String password) {
        this.user = user;
        this.password = password;
    }


    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "MarkLogic{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/spring-context.xml");
        MarkLogic markLogic = (MarkLogic) context.getBean("markLogic");

        System.out.println(markLogic);

    }
}
