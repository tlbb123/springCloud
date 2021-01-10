package com.tllt.springcloud.service.impl;

import com.tllt.springcloud.entities.Payment;
import com.tllt.springcloud.mapper.PaymentMapper;
import com.tllt.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;

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
        int i = paymentMapper.create(payment);
        int c=2/i;
        return i;
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentMapper.getPaymentById(paymentId);
    }
}
