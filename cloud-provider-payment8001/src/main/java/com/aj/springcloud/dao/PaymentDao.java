package com.aj.springcloud.dao;

import com.aj.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @Author Aj
 * @Date 2020/8/14 0014 16:30
 * @Version 1.0
 */
@Mapper
public interface PaymentDao
{
     int create(Payment payment);

    // @Select("select * from payment where id=#{id}")
     Payment getPaymentById(@Param("id") Long id);
}
