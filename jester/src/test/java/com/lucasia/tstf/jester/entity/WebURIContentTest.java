package com.lucasia.tstf.jester.entity;

import com.lucasia.tstf.jester.util.IOUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * User: lucasia
 */
public class WebURIContentTest {
    @Test
    public void testFileContent() throws URISyntaxException, IOException {
        URL webURL = new URL("http://www-personal.umich.edu/~lucian/");

        final InputStream contentStream = new WebURIContent(webURL.toURI()).getContentStream();

        final String content = IOUtil.streamToString(contentStream);

        Assert.assertTrue(content.startsWith("<html>"));

    }

}
