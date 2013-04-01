package com.lucasia.tstf.jester.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;

/**
 * User: lucasia
 *
 * TODO: add Proxy as a property
 */
public class WebContent extends Content {
    public WebContent(URI uri) {
        super(uri);
    }


    @Override
    public InputStream getContentStream() throws IOException {
        URLConnection connection = getUri().toURL().openConnection();
        return connection.getInputStream();
    }
}
