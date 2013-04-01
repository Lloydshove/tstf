package com.lucasia.tstf.jester.inbound;

import com.lucasia.tstf.jester.Content;

import java.util.*;

/**
* User: lucasia
*/
public class QueueContentSource implements ContentSource {
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
