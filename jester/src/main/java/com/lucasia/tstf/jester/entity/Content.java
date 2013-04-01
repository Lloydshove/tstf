package com.lucasia.tstf.jester.entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * User: lucasia
 */
public interface Content<T> {

    URI getURI();

    T getContent();

    InputStream getContentStream() throws IOException;

}
