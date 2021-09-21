package com.tllt.springcloud.service;

import com.tllt.springcloud.entities.CommonResult;
import com.tllt.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentOpenFeignService {

    @GetMapping("/payment/{id}")
     CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/timeout")
     void getTimeOut();


}
