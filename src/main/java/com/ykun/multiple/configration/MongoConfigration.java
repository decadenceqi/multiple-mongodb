package com.ykun.multiple.configration;

import com.mongodb.MongoClientURI;
import com.ykun.multiple.core.BaseMongoRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * @author Ykun 于 2017-06-16 16:15
 */
@Configuration
public class MongoConfigration {

    @Value("${mongodb.master.uri}")
    private String mongoMasterURI;

    @Value("${mongodb.slave.uri}")
    private String mongoSlaveURI;

    @Bean(name = "masterTemplate")
    public MongoTemplate masterTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(mongoMasterURI)));
    }

    @Bean(name = "slaveTemplate")
    public MongoTemplate slaveTemplate() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI(mongoSlaveURI)));
    }

    @EnableMongoRepositories(basePackages = "com.ykun.multiple.repository.master", mongoTemplateRef = "masterTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class MasterMongoConfigration {

    }

    @EnableMongoRepositories(basePackages = "com.ykun.multiple.repository.slave", mongoTemplateRef = "slaveTemplate", repositoryBaseClass = BaseMongoRepositoryImpl.class)
    private class SlaveMongoConfigration {

    }


}
