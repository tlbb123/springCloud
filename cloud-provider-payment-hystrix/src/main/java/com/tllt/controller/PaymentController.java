package com.tllt.controller;

import com.tllt.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tllt
 * @create 2021/1/3
 */
@RestController
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_Ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id")Integer id){
        return paymentService.paymentInfo_TimeOut(id);
    }

        @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        String s="";
        try {
            s = paymentService.paymentCircuitBreaker(id);
         }catch (Exception e){
             e.printStackTrace();
         }
        return s;
    }
}
