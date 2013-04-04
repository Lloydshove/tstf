package com.lucasia.tstf.jester.providers.marklogic;

import com.lucasia.tstf.jester.entity.Content;
import com.lucasia.tstf.jester.entity.StringContent;
import com.lucasia.tstf.jester.io.IORuntimeException;
import com.lucasia.tstf.jester.security.PasswordAuthenticator;
import com.lucasia.tstf.jester.io.IOUtil;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.*;

/**
 * User: lucasia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class MarkLogicConfigTest {

    @Autowired
    MarkLogicConfig markLogicConfig;

    @Test
    public void testConfigLoading() throws URISyntaxException, IOException {
        Assert.assertNotNull(markLogicConfig);
        Assert.assertNotNull(markLogicConfig.getUser());
        Assert.assertNotNull(markLogicConfig.getPassword());
        Assert.assertNotNull(markLogicConfig.getServerURL());
        Assert.assertNotNull(markLogicConfig.getDocPrefix());
    }

    @Before
    public void setUp() throws Exception {
        new PasswordAuthenticator().setDefaultAuthenticator(markLogicConfig.getUser(), markLogicConfig.getPassword());
    }

    @Test
    /**
     *  Equivalent of:
     *  curl --anyauth --user user:pass -X PUT -d@'./two.json' 'http://server:port/v1/documents?uri=/json/two.json'
     *  curl --anyauth --user user:pass -X GET 'http://server:port/v1/documents?uri=/json/two.json'
     *  curl --anyauth --user user:pass -X DELETE -i 'http://server:port:8003/v1/documents?uri=/xml/pom.xml'
     *
     */
    public void testCreateAndRetrieveContent() throws Exception {
        // define content to add
        final String contentStr = "<text>Hello World!</text>";
        final URI contentURI = new URI("/xml/hello-world.xml");

        final StringContent content = new StringContent(markLogicConfig.getDocURI(contentURI), contentStr);


        final MarkLogicDAO dao = new MarkLogicDAO();


        dao.save(content);  // save content

        // retrieve content
        Content retrievedContent = dao.get(content.getURI());
        XMLAssert.assertXMLEqual(contentStr, IOUtil.streamToString(retrievedContent.getContentStream()));


        dao.delete(content);   // clean up


        try {
            dao.get(content.getURI());    // should no longer be there
        } catch (IORuntimeException e) {
            Assert.assertEquals(FileNotFoundException.class, e.getWrappedException().getClass());
        }
    }




}
