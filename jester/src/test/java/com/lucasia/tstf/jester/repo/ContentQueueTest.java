package com.lucasia.tstf.jester.repo;

import com.lucasia.tstf.jester.entity.Content;
import com.lucasia.tstf.jester.entity.StringContent;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: lucasia
 */
public class ContentQueueTest {

    @Test
    public void testQueueDequeue() throws URISyntaxException {
        Content a = new StringContent(new URI("http://foo/a"), "a");
        Content b = new StringContent(new URI("http://foo/b"), "b");

        ContentQueue contentQueue = new SimpleContentQueue();

        contentQueue.add(a);
        contentQueue.add(b);

        Assert.assertEquals(a, contentQueue.remove());
        Assert.assertEquals(b, contentQueue.remove());
    }

}
