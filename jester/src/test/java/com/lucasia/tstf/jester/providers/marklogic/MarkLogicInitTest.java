package com.lucasia.tstf.jester.providers.marklogic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * User: lucasia
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml"})
public class MarkLogicInitTest {

    @Autowired
    MarkLogicConfig markLogicConfig;

    @Test
    /**
     *  Equivalent of:
     * curl --anyauth --user lucasia:lucasia -X POST -d'<rest-api xmlns="http://marklogic.com/rest-api"><name>lucasia-rest</name></rest-api>' \
     *  -H "Content-type: application/xml" http://giniro.local:8002/v1/rest-apis
     *
     * curl --anyauth --user lucasia:lucasia -X DELETE 'http://giniro.local:8002/v1/rest-apis/lucasia-rest?include=content&include=modules'
     */
    public void testCreateDatabase() throws Exception {


    }

}
