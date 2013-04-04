package com.lucasia.tstf.jester.providers.marklogic;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: lucasia
 *
 */
@Component
public class MarkLogicConfig {
    private String user;
    private String password;
    private URI configURL;

    private URI restURL;
    private String restDocPrefix;

    public MarkLogicConfig(String user, String password, String configURL, String restURL, String restDocPrefix) throws URISyntaxException {
        this.user = user;
        this.password = password;

        this.configURL = new URI(configURL);
        this.restURL = new URI(restURL);

        this.restDocPrefix = restDocPrefix;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public URI getConfigURL() {
        return configURL;
    }

    public URI getRestURL() {
        return restURL;
    }

    public String getRestDocPrefix() {
        return restDocPrefix;
    }

    public URI getDocURI(URI docuURI) {
        return restURL.resolve(restDocPrefix + docuURI.toASCIIString());
    }


}
