package com.lucasia.tstf.jester.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public abstract class Content {

    private URI id;

    protected Content(URI id) {
        this.id = id;
    }

    public URI getId() {
        return id;
    }

    public abstract InputStream getContentStream() throws IOException;

    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
