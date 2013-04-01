package com.lucasia.tstf.jester.inbound;

import com.lucasia.tstf.jester.Content;
import com.lucasia.tstf.jester.StringContent;
import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: lucasia
 */
public class QueueContentSourceTest {

    @Test
    public void testQueueDequeue() throws URISyntaxException {
        Content a = new StringContent(new URI("http://foo/a"), "a");
        Content b = new StringContent(new URI("http://foo/b"), "b");

        ContentSource contentSource = new QueueContentSource();

        contentSource.add(a);
        contentSource.add(b);

        Assert.assertEquals(a, contentSource.remove());
        Assert.assertEquals(b, contentSource.remove());
    }

}
