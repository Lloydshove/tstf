package com.lucasia.tstf.jester;

import java.net.URI;

/**
 * User: lucasia
 */
public class Content {

    private URI id;
    private String content;

    public Content(URI id, String content) {
        this.id = id;
        this.content = content;
    }

    public URI getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
