package com.aj.springcloud.service.impl;

import com.aj.springcloud.dao.PaymentDao;
import com.aj.springcloud.entities.Payment;
import com.aj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Aj
 * @Date 2020/8/14 0014 16:53
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService
{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
