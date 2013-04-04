package com.lucasia.tstf.jester.entity;

import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public class WebURIContent extends URIContent<InputStream> {
    private InputStream stream;

    public WebURIContent(URI uri) {
        super(uri);
        this.stream = getContentStream();
    }

    public WebURIContent(URI uri, InputStream stream) {
        super(uri);
        this.stream = stream;
    }

    @Override
    public InputStream getContent() {
        return stream;
    }
}
