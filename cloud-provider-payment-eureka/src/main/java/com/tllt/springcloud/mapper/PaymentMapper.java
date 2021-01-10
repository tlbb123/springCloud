package com.tllt.springcloud.mapper;

import com.tllt.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tllt
 * @create 2020/11/30
 */
@Mapper
public interface PaymentMapper {
     int create(Payment payment);

     Payment getPaymentById(@Param("paymentId")Long paymentId);
}
