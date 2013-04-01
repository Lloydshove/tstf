package com.lucasia.tstf.jester.entity;

import java.io.File;

/**
 * User: lucasia
 */
public class FileURIContent extends URIContent<File> {
    private File content;

    public FileURIContent(File content) {
        super(content.toURI());
        this.content = content;
    }

    @Override
    public File getContent() {
        return content;
    }
}
