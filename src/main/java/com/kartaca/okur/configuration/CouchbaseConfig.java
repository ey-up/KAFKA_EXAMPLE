package com.kartaca.okur.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = "com.kartaca.okur.repository")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {

        return "localhost";
    }

    @Override
    public String getUserName() {

        return "eyup";
    }

    @Override
    public String getPassword() {

        return "eyup123";
    }

    @Override
    public String getBucketName() {
        return "Logs";
    }
}
