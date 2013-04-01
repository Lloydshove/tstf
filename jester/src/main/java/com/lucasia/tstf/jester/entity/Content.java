package com.lucasia.tstf.jester.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public abstract class Content {
    private URI uri;

    protected Content(URI uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    public abstract InputStream getContentStream() throws IOException;

    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
