package com.lucasia.tstf.jester.io;

import java.io.IOException;

/**
 * User: lucasia
 */
public class IORuntimeException extends RuntimeException {

    private IOException wrappedException;

    public IORuntimeException(IOException wrappedException) {
        super(wrappedException);
        this.wrappedException = wrappedException;
    }

    public IOException getWrappedException() {
        return wrappedException;
    }
}
