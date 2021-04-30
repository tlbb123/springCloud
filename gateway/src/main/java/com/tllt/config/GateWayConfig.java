package com.tllt.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tllt
 * @create 2021/3/21
 */
@Configuration
public class GateWayConfig {

    /**
     * 配置路由规则，当访问的地址为http://localhost:9090/guonei时，
     *  会转发到相应的uri
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routers=builder.routes();
        routers.route("path_route_tllt",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        routers.route("path_route_tllt",
                r->r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();
        return routers.build();
    }
}
