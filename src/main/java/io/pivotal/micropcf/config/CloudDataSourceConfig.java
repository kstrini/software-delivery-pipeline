package io.pivotal.micropcf.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig
{
    @Bean
    public MongoDbFactory documentMongoDbFactory() {return connectionFactory().mongoDbFactory();}

//    @Bean
//    public DataSource dataSource() {return connectionFactory().dataSource();}

//    @Bean
//    public ConnectionFactory rabbitConnectionFactory(){return connectionFactory().rabbitConnectionFactory();}

//    @Bean
//    public DataSource gemfirexdDataSource(){return connectionFactory().dataSource();}

//    @Bean
//    public Configuration hadoopConfiguration(){return connectionFactory().service(Configuration.class);}

}