package com.lucasia.tstf.jester.providers.marklogic;

import com.lucasia.tstf.jester.http.HttpURLConnectionWrapper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User: lucasia
 */
public class MarkLogicDBInit {
    private String dbName;
    private URL url;

    public MarkLogicDBInit(String dbName, URL url) {
        this.dbName = dbName;
        this.url = url;
    }

    public void createDatabase() throws IOException {
        final String body = "<rest-api xmlns=\"http://marklogic.com/rest-api\">" + dbName + "</rest-api>";

        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/xml; charset=utf-8");

        new HttpURLConnectionWrapper(conn).sendBody(body);
    }


    public void deleteDatabase() throws IOException {
        final URL dbURL = new URL(url, dbName + "?include=content&include=modules");

        final HttpURLConnection conn = (HttpURLConnection) dbURL.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setDoOutput(true);
    }


}
