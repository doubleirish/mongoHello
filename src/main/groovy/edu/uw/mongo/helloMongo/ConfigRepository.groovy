package edu.uw.mongo.helloMongo;

/**
 * Created by credmond on 5/25/16.
 */
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigRepository extends MongoRepository<Config, String> {

    public List<Config> findByApp(String app);
    public List<Config> findByEnv(String env);
   public List<Config> findByAppAndEnv(String app, String env);

}