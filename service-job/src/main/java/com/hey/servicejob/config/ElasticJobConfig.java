package com.hey.servicejob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class ElasticJobConfig {

    @Value("${spring.cloud.zookeeper.connect-string}")
    private String zkNodes;


    public ZookeeperConfiguration zkConfig() {
        String namespace = "hey";
        return new ZookeeperConfiguration(zkNodes, namespace);
    }

    public ZookeeperRegistryCenter regCenter(ZookeeperConfiguration config) {
        return new ZookeeperRegistryCenter(config);
    }


}
