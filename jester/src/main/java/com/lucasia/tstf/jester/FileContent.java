package com.lucasia.tstf.jester;

import java.io.*;
import java.net.URI;

/**
 * User: lucasia
 */
public class FileContent extends Content {
    private File content;

    public FileContent(File content) {
        super(content.toURI());
        this.content = content;
    }

    @Override
    public InputStream getContentStream() throws IOException {
        return new FileInputStream(content);
    }
}
