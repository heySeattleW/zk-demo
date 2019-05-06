package com.hey.servicejob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.hey.servicejob.config.ElasticJobConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyJob implements SimpleJob {

    @Autowired
    ElasticJobConfig config;


    @Override
    public void execute(ShardingContext shardingContext) {
        int shardIndex = shardingContext.getShardingItem();
        if (shardIndex % 2 == 0) {
            //处理id为奇数的商家
            System.out.println("这是奇数");
        } else {
            //处理id为偶数的商家
            System.out.println("这是偶数");
        }
    }

    public void doJob(){
        new JobScheduler(config.regCenter(config.zkConfig()), createJobConfiguration()).init();
    }


    private static LiteJobConfiguration createJobConfiguration() {
        JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder("demoSimpleJob", "0/15 * * * * ?", 10).build();
        // 定义SIMPLE类型配置
        SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, MyJob.class.getCanonicalName());
        // 定义Lite作业根配置
        LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
        return simpleJobRootConfig;
    }
}
