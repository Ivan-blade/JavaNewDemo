package com.ivan.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author hylu.ivan
 * @date 2022/2/7 下午9:46
 * @description
 */
@ConfigurationProperties(prefix = "hbase")
@Component
public class HBaseConfig {

    private Logger logger = LoggerFactory.getLogger(HBaseConfig.class);

    private Map<String, String> config;

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }

    /**
     * 最小重试间隔（单位：毫秒）
     */
    private static final int MIN_RETRY_INTERVAL = 100;

    /**
     * 最大重试间隔（1分钟）
     */
    private static final int MAX_RETRY_INTERVAL = 60 * 1000;


    @Bean
    public Connection hbaseConnection(HBaseConfig hbaseConfig) {
        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();
        Map<String, String> config = hbaseConfig.getConfig();
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            configuration.set(key, config.get(key));
        }
        int sleep = MIN_RETRY_INTERVAL;
        while (true) {
            try {
                Connection conn = ConnectionFactory.createConnection(configuration);
                return conn;
            } catch (IOException ex) {
                logger.error("Create HBase Connection failed, Retry after " + sleep + "ms", ex);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sleep = Math.min(sleep * 2, MAX_RETRY_INTERVAL);
            }
        }
    }
}
