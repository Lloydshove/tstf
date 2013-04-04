package com.lucasia.tstf.jester.providers.marklogic;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * User: lucasia
 */
@Component
public class MarkLogic {
    private String user;
    private String password;
    private String url;

    public MarkLogic(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/spring-context.xml");
        MarkLogic markLogic = (MarkLogic) context.getBean("markLogic");

        System.out.println(markLogic);

    }
}
