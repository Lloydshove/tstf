package com.lucasia.tstf.jester.http;

import com.lucasia.tstf.jester.io.IOUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * User: lucasia
 *
 * TODO: look to replace with Apache HTTP Libraries
 * http://hc.apache.org/
 *
 */
public class HttpURLConnectionWrapper {
    private HttpURLConnection conn;

    public HttpURLConnectionWrapper(HttpURLConnection conn) {
        this.conn = conn;
    }

    public void validateResponse() throws IOException {
        if (!Integer.toString(conn.getResponseCode()).startsWith("2")) { // 2XX is Success code
            String error = conn.getErrorStream() != null ? IOUtil.streamToString(conn.getErrorStream()) : " No error stream.";
            throw new RuntimeException("Response code + '" + conn.getResponseCode() + "'. " + error);
        }
    }

    public void sendBody(String body) throws IOException {
        final OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());

        out.write(body);
        out.flush();
        out.close();
        conn.disconnect();

        validateResponse();
    }
}
