package com.lucasia.tstf.jester.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;

/**
 * User: lucasia
 */
public abstract class URIContent<T> implements Content<T> {
    private URI uri;

    protected URIContent(URI uri) {
        this.uri = uri;
    }

    public URI getURI() {
        return uri;
    }

    public InputStream getContentStream() throws IOException {
        URLConnection connection = uri.toURL().openConnection();
        return connection.getInputStream();
    }
}
