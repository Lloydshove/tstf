package com.lucasia.tstf.jester.repo;

import com.lucasia.tstf.jester.entity.Content;

/**
 * User: lucasia
 */
public interface ContentQueue {

    boolean add(Content content);

    Content remove();
}
