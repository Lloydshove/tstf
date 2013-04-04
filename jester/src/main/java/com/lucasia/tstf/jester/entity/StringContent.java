package com.lucasia.tstf.jester.entity;

import com.lucasia.tstf.jester.util.IOUtil;

import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public class StringContent implements Content<String> {
    private URI uri;
    private String content;

    public StringContent(URI uri, String content) {
        this.uri = uri;
        this.content = content;
    }

    @Override
    public URI getURI() {
        return uri;
    }

    @Override
    public InputStream getContentStream() {
        return IOUtil.stringToStream(content);
    }

    public String getContent() {
        return content;
    }

}
