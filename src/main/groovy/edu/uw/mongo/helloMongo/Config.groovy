package edu.uw.mongo.helloMongo;


import org.springframework.data.annotation.Id;


public class Config {

   @Id
    String id;


    String env;

    String app;

    Integer batchSize;
    Integer scanningNewDataInterval;
    Integer connectionRecoverInterval;
    Integer refreshDsConnInterval;

    Integer minLogThreshold;
    Integer maxLogThreshold;
    String logFile;
    Boolean disableBroadcasting;

    Boolean debug;
    String dbPoolBeanName;
    Boolean dbVerbose;
    Boolean debugDoDeletes;
    Integer dbMaxConnectionRetry;
    Integer dbMaxConnectionRetryInterval;





   @Override
   public String toString() {
      return """\
    Config {
          id = '$id',
          env = '$env',
          app = '$app',
          batchSize = $batchSize,
          scanningNewDataInterval = $scanningNewDataInterval,
          connectionRecoverInterval = $connectionRecoverInterval,
          refreshDsConnInterval = $refreshDsConnInterval,
          minLogThreshold = $minLogThreshold,
          maxLogThreshold = $maxLogThreshold,
          logFile = '$logFile',
          disableBroadcasting = $disableBroadcasting,
          debug = $debug,
          dbPoolBeanName = '$dbPoolBeanName',
          dbVerbose = $dbVerbose,
          debugDoDeletes = $debugDoDeletes,
          dbMaxConnectionRetry = $dbMaxConnectionRetry,
          dbMaxConnectionRetryInterval = $dbMaxConnectionRetryInterval
    } """
   }




}
