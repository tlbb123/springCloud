package com.tllt.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author tllt
 * @create 2020/11/30
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
   @Value("${server.port}")
    private String serverPort;

   @GetMapping("/consul")
   public String paymentzk(){
       return "SpringCloud with consul: "+ serverPort+"\t"+ UUID.randomUUID().toString();
   }
}
