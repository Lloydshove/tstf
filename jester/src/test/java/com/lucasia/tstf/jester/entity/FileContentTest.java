package com.lucasia.tstf.jester.entity;

import com.lucasia.tstf.jester.io.IOUtil;
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
        URL fileURL = this.getClass().getResource("./xml/person-ian.xml");

        FileContent fileContent = new FileContent(new File(fileURL.getFile()));

        final InputStream contentStream = fileContent.getContentStream();

        final String content = IOUtil.streamToString(contentStream);

        Assert.assertEquals("<person><name>Ian</name></person>", content);

    }
}
