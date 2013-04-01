package com.lucasia.tstf.jester.entity;

import java.io.*;

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
