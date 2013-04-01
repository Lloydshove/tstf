package com.lucasia.tstf.jester;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * User: lucasia
 */
public class FileContentTest {

    @Test
    public void testFileContent() throws URISyntaxException, IOException {
        URL fileURL = this.getClass().getResource("/person-ian.xml");

        FileContent fileContent = new FileContent(new File(fileURL.getFile()));

        final InputStream contentStream = fileContent.getContentStream();

        final String content = Content.convertStreamToString(contentStream);

        Assert.assertEquals("<person><name>Ian</name></person>", content);

    }
}
