package com.aj.springcloud.service;

import com.aj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Aj
 * @Date 2020/8/14 0014 16:51
 * @Version 1.0
 */
public interface PaymentService
{
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
