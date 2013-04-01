package com.lucasia.tstf.jester;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public class StringContent extends Content {
    private String content;

    public StringContent(URI id, String content) {
        super(id);
        this.content = content;
    }

    @Override
    public InputStream getContentStream() {
        return new ByteArrayInputStream(content.getBytes());
    }

    public String getContent() {
        return content;
    }
}
