package com.lucasia.tstf.jester.providers.marklogic;

import com.lucasia.tstf.jester.entity.StringContent;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.*;

/**
 * User: lucasia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/META-INF/spring/spring-context.xml"})
public class MarkLogicTest {

    @Autowired
    MarkLogic markLogic;

    @Test
    public void testConfigLoading() throws URISyntaxException, IOException {
        Assert.assertNotNull(markLogic);
        Assert.assertNotNull(markLogic.getUser());
        Assert.assertNotNull(markLogic.getPassword());
    }

    @Test
    @Ignore // still very much a work in progress
    public void testRetrieve() throws URISyntaxException, IOException {
        URI serverURI = new URI("http://giniro.local:8003/v1/documents?uri=/json/two.json&format=json");

        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(markLogic.getUser(), markLogic.getPassword().toCharArray());
            }
        });

        URL url = serverURI.toURL();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        final String s = StringContent.streamToString(connection.getInputStream());

        System.out.println("s = " + s);


    }

}
