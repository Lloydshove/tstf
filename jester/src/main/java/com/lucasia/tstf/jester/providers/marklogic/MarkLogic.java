package com.lucasia.tstf.jester.providers.marklogic;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: lucasia
 */
@Component
public class MarkLogic {
    private String user;
    private String password;
    private URI serverURL;
    private String docPrefix;

    public MarkLogic(String user, String password, String serverURL, String docPrefix) {
        this.user = user;
        this.password = password;
        try {
            this.serverURL = new URI(serverURL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        this.docPrefix = docPrefix;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public URI getServerURL() {
        return serverURL;
    }

    public String getDocPrefix() {
        return docPrefix;
    }

    public URI getDocURI(URI docuURI) {
        return serverURL.resolve(docPrefix + docuURI.toASCIIString());
    }

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/spring-context.xml");
        MarkLogic markLogic = (MarkLogic) context.getBean("markLogic");

        System.out.println(markLogic);

    }
}
