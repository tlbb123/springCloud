package com.tllt.springcloud.service;

import com.tllt.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tllt
 * @create 2020/11/30
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);
}
