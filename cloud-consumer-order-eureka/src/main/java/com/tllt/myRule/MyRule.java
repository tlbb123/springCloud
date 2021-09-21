package com.tllt.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tllt
 * @create 2020/12/20
 */
@Configuration
public class MyRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}
