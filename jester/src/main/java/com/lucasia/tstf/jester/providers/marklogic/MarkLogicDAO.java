package com.lucasia.tstf.jester.providers.marklogic;

import com.lucasia.tstf.jester.http.HttpURLConnectionWrapper;
import com.lucasia.tstf.jester.io.IOUtil;
import com.lucasia.tstf.jester.dao.Dao;
import com.lucasia.tstf.jester.entity.Content;
import com.lucasia.tstf.jester.entity.URIContent;
import com.lucasia.tstf.jester.io.IORuntimeException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

/**
 * User: lucasia
 *
 * TODO: look to replace with Apache HTTP Libraries
 * http://hc.apache.org/
 *
 */
public class MarkLogicDAO implements Dao<URI, Content> {

    @Override
    public URIContent get(URI uri) {
        try {
            final HttpURLConnection conn = (HttpURLConnection) IOUtil.getUrl(uri).openConnection();
            conn.setRequestMethod("GET"); // defaults to GET, but be explicit
            return new URIContent(uri, conn.getInputStream());

        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    @Override
    public void save(Content content) {
        try  {

            final URL url = IOUtil.getUrl(content.getURI());
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);

            final String body = IOUtil.streamToString(content.getContentStream()); // TODO: replace with pipe to output

            new HttpURLConnectionWrapper(conn).sendBody(body);

        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    @Override
    public void delete(Content content) {
        try {
            final URL url = IOUtil.getUrl(content.getURI());

            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setDoOutput(true);

            new HttpURLConnectionWrapper(conn).validateResponse();

        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

}
