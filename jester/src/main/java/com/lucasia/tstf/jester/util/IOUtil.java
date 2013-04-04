package com.lucasia.tstf.jester.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
}
