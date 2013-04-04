package com.lucasia.tstf.jester.io;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * User: lucasia
 */
public class IOUtil {
    public static String streamToString(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static InputStream stringToStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static URL getUrl(URI uri) {
        final URL url;
        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new IORuntimeException(e);
        }
        return url;
    }
}
