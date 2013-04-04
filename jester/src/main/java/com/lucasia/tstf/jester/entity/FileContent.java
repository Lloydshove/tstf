package com.lucasia.tstf.jester.entity;

import java.io.File;
import java.io.IOException;

/**
 * User: lucasia
 */
public class FileContent extends URIContent {
    private File file;

    public FileContent(File file) throws IOException {
        super(file.toURI());
        this.file = file;
    }

    public File getFile() {
        return file;
    }
}
