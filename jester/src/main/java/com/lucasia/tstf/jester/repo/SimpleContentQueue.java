package com.lucasia.tstf.jester.repo;

import com.lucasia.tstf.jester.entity.Content;

import java.util.*;

/**
* User: lucasia
*/
public class SimpleContentQueue implements ContentQueue {
    private Queue<Content> queue = new LinkedList<Content>();

    @Override
    public boolean add(Content content) {
        return queue.add(content);
    }

    @Override
    public Content remove() {
        return queue.remove();
    }

    public Iterator<Content> iterator() {
        return queue.iterator();
    }
}
