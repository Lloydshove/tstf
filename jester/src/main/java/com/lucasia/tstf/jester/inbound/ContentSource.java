package com.lucasia.tstf.jester.inbound;

import com.lucasia.tstf.jester.Content;

/**
 * User: lucasia
 */
public interface ContentSource {

    boolean add(Content content);

    Content remove();
}
