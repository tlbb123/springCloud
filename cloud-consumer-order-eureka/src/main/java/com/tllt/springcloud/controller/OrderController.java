package com.tllt.springcloud.controller;

import com.tllt.springcloud.entities.CommonResult;
import com.tllt.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.beans.Transient;

/**
 * @author tllt
 * @create 2020/12/2
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CommonResult<Payment> create( Payment payment){
        CommonResult<Payment> commonResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        restTemplate.postForObject(PAYMENT_URL + "/payment/create", new Payment(0L,"0"), CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }
}
