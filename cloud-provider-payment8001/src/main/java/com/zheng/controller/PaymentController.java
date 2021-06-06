package com.zheng.controller;

import com.zheng.entities.CommonResult;
import com.zheng.entities.Payment;
import com.zheng.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 郑超
 * @create 2021/6/6
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("param: " + payment + " result: " + i);
        if (i > 0)
            return new CommonResult(200, "插入数据成功", i);
        else
            return new CommonResult(500, "插入数据失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("param: " + id + " result: " + payment);
        if (payment != null)
            return new CommonResult(200, "查询成功", payment);
        else
            return new CommonResult(500, "查询失败", null);
    }
}
