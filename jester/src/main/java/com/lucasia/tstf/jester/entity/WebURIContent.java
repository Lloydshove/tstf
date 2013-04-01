package com.lucasia.tstf.jester.entity;

import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public class WebURIContent extends URIContent<InputStream> {

    public WebURIContent(URI uri) {
        super(uri);
    }

    @Override
    public InputStream getContent() {
        return getContentStream();
    }
}
