package com.zheng.service;

import com.zheng.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郑超
 * @create 2021/6/6
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
