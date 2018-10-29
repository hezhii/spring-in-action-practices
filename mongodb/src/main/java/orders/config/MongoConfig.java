package orders.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
//import org.springframework.data.mongodb.core.MongoFactoryBean;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 除了直接声明 bean，还可以继承 AbstractMongoConfiguration 并重载 getDatabaseName 和 mongo 方法。
 */
//@Configuration
//@EnableMongoRepositories(basePackages = "orders.db")
//public class MongoConfig {
//    @Bean
//    public MongoFactoryBean mongo() {
//        MongoFactoryBean mongo = new MongoFactoryBean();
//        mongo.setHost("localhost");
//        return mongo;
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate(Mongo mongo) {
//        return new MongoTemplate(mongo, "OrdersDB");
//    }
//}


/**
 * 没有直接声明 MongoTemplate bean，会被隐式创建。
 */
@Configuration
@EnableMongoRepositories(basePackages = "orders.db")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient();
    }

}
