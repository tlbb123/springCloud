package com.tllt.springcloud.service.impl;

import com.tllt.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author tllt
 * @create 2021/1/10
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "服务中断,请稍后再试";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "服务中断,请稍后再试";
    }
}
