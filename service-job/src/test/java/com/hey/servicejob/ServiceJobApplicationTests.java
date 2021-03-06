package com.hey.servicejob;

import com.hey.servicejob.job.MyJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceJobApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    MyJob myJob;

    @Test
    public void testJob() throws InterruptedException {
        myJob.doJob();
        Thread.sleep(100000L);
    }

}
