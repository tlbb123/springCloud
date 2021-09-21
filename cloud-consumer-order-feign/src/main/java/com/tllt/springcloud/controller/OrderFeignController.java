package com.tllt.springcloud.controller;

import com.tllt.springcloud.entities.CommonResult;
import com.tllt.springcloud.entities.Payment;
import com.tllt.springcloud.service.PaymentOpenFeignService;
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
public class OrderFeignController {
    private final PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentOpenFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public void getTimeOut(){
         paymentOpenFeignService.getTimeOut();
    }
}
