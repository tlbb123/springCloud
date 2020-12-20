package com.tllt.springcloud.service.impl;

import com.tllt.springcloud.entities.Payment;
import com.tllt.springcloud.mapper.PaymentMapper;
import com.tllt.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tllt
 * @create 2020/11/30
 */
@Service
public class PaymentServiceImpl  implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentMapper.getPaymentById(paymentId);
    }
}
