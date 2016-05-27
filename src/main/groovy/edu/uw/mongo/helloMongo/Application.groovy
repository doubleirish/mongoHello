package edu.uw.mongo.helloMongo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
public class Application implements CommandLineRunner {

   @Autowired
   private ConfigRepository repository;

   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Override
   public void run(String... args) throws Exception {

      repository.deleteAll();

      // save a couple of customers
      repository.save(new Config([
              app                           : 'wordpress'
              , env                         : 'production'
              , batchSize                   : 50
              , scanningNewDataInterval     : 5000
              , connectionRecoverInterval   : 1000
              , refreshDsConnInterval       : 5000
              , minLogThreshold             : 50
              , maxLogThreshold             : 50
              , logFile                     : "/var/logs/wordpress.log"
              , disableBroadcasting         : false
              , debug                       : false
              , dbPoolBeanName              : 'wpDataSource'
              , dbVerbose                   : false
              , debugDoDeletes              : true
              , dbMaxConnectionRetry        : -1
              , dbMaxConnectionRetryInterval: 5000
      ]))


      repository.save(new Config([
                app                           : 'wordpress'
                , env                         : 'dev'
                , batchSize                   : 50
                , scanningNewDataInterval     : 5000
                , connectionRecoverInterval   : 1000
                , refreshDsConnInterval       : 5000
                , minLogThreshold             : 50
                , maxLogThreshold             : 50
                , logFile                     : "/var/logs/wordpress.log"
                , disableBroadcasting         : false
                , debug                       : false
                , dbPoolBeanName              : 'wpDataSourceDev'
                , dbVerbose                   : false
                , debugDoDeletes              : true
                , dbMaxConnectionRetry        : -1
                , dbMaxConnectionRetryInterval: 5000
        ]))

      repository.save(new Config([
              app                           : 'mysql'
              , env                         : 'dev'
              , batchSize                   : 50
              , scanningNewDataInterval     : 5000
              , connectionRecoverInterval   : 1000
              , refreshDsConnInterval       : 5000
              , minLogThreshold             : 50
              , maxLogThreshold             : 50
              , logFile                     : "/var/logs/mysql.log"
              , disableBroadcasting         : false
              , debug                       : false
              , dbVerbose                   : false
              , debugDoDeletes              : true
              , dbMaxConnectionRetry        : -1
              , dbMaxConnectionRetryInterval: 5000
      ]))

      repository.save(new Config([
                 app                           : 'mysql'
                 , env                         : 'production'
                 , batchSize                   : 50
                 , scanningNewDataInterval     : 5000
                 , connectionRecoverInterval   : 1000
                 , refreshDsConnInterval       : 5000
                 , minLogThreshold             : 50
                 , maxLogThreshold             : 50
                 , logFile                     : "/var/logs/mysql.log"
                 , disableBroadcasting         : false
                 , debug                       : false
                 , dbVerbose                   : false
                 , debugDoDeletes              : true
                 , dbMaxConnectionRetry        : -1
                 , dbMaxConnectionRetryInterval: 5000
         ]))


      repository.save(new Config([
                    app                           : 'kafka'
                    , env                         : 'dev'
                    , batchSize                   : 50
                    , scanningNewDataInterval     : 5000
                    , connectionRecoverInterval   : 1000
                    , refreshDsConnInterval       : 5000
                    , minLogThreshold             : 50
                    , maxLogThreshold             : 50
                    , logFile                     : "/var/logs/kafka.log"
                    , disableBroadcasting         : false
                    , debug                       : false
                    , dbPoolBeanName              : 'dbsiDataSource'
                    , dbVerbose                   : false
                    , debugDoDeletes              : true
                    , dbMaxConnectionRetry        : -1
                    , dbMaxConnectionRetryInterval: 5000
            ]))

      //  find all config docs
      println("Config found with findAll():");
      println("-------------------------------");
      for (Config config : repository.findAll()) {
         def env = config.getEnv()
         println("$env $config");
      }
      println();

      // fetch config docs by application type
      println("Config found with findByApp('wordpress'):");
      println("--------------------------------");
      println(repository.findByApp("wordpress"));


      println("Config found with findByEnv('production)");
      println("--------------------------------");
      for (Config config : repository.findByEnv("production")) {
         println(config);
      }

      println("Config found with findByAppAndEnv(\"wordpress\",\"production\")   ");
      println("--------------------------------");
      for (Config config : repository.findByAppAndEnv("wordpress", "production")) {
         println(config);
      }

      def count = repository.count();
      println("Count Records =$count");



   }

}