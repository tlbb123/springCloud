package com.tllt.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author tllt
 * @create 2021/1/3
 */
@Service
public class PaymentService {

    public String paymentInfo_Ok(Integer id){
        return "线程池： "+Thread.currentThread().getName()+" PaymentInfo_Ok"+id+"\t";
    }


    public String paymentInfo_TimeOut(Integer id){
        int c=1/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+" paymentInfo_TimeOut"+id+"\t";
    }

    @HystrixCommand(fallbackMethod = "paymentFallbackById",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否启用断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),       //统计次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //窗口时间
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")      //跳闸的失败率

    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0){
            throw new RuntimeException("id不能小于0");
        }
        String serialNumber= UUID.randomUUID().toString();
        return Thread.currentThread().getName() +
                "\t" +
                "调用成功，流水号 :" +
                serialNumber;
    }

    public String paymentFallbackById(Integer id){
        return "服务调用失败，请稍后再试，id= "+id;
    }


}
