package com.lucasia.tstf.jester.dao;

import com.lucasia.tstf.jester.entity.Content;
import com.lucasia.tstf.jester.entity.URIContent;
import com.lucasia.tstf.jester.util.IOUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * User: lucasia
 */
public class RESTDao implements Dao<URI, Content> {
    @Override
    public URIContent get(URI uri) {
        try {
            final HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET"); // defaults to GET, but be explicit
            return new URIContent(uri, conn.getInputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Content content) {
        try  {

            final URL url = content.getURI().toURL();
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);

            final OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

            final String str = IOUtil.streamToString(content.getContentStream()); // TODO: replace with pipe to output

            out.write(str);
            out.flush();
            out.close();
            conn.disconnect();

            validateResponse(conn);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Content content) {
        try {
            final URL url = content.getURI().toURL();
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);
            // conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            validateResponse(conn);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateResponse(HttpURLConnection conn) throws IOException {


        if (!Integer.toString(conn.getResponseCode()).startsWith("2")) { // 2XX is Success code
            String error = conn.getErrorStream() != null ? IOUtil.streamToString(conn.getErrorStream()) : " No error stream.";
            throw new RuntimeException("Response code + '" + conn.getResponseCode() + "'. " + error);
        }
    }
}
