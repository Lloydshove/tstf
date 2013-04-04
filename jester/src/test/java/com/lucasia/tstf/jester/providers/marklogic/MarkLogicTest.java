package com.lucasia.tstf.jester.providers.marklogic;

import com.lucasia.tstf.jester.entity.StringContent;
import com.lucasia.tstf.jester.security.PasswordAuthenticator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

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
        Assert.assertNotNull(markLogic.getUrl());
    }

    @Before
    public void setUp() throws Exception {
        new PasswordAuthenticator().setDefaultAuthenticator(markLogic.getUser(), markLogic.getPassword());
    }

    @Test
    @Ignore // integration test
    public void testRetrieve() throws URISyntaxException, IOException {
        String json = "{\"two\":{\"child\":\"I come to bury Caesar, not to praise him.\"}}";

        final URI serverURI = new URI(markLogic.getUrl() + "/v1/documents?uri=/json/two.json&format=json");

        final URLConnection connection = serverURI.toURL().openConnection();

        Assert.assertEquals(json, StringContent.streamToString(connection.getInputStream()));
    }


}
