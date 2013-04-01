package com.lucasia.tstf.jester.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Scanner;

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
        return stringToStream(content);
    }

    public String getContent() {
        return content;
    }

    public static String streamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


    public static InputStream stringToStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }
}
