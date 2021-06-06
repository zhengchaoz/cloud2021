package com.zheng.controller;

import com.zheng.entities.CommonResult;
import com.zheng.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 郑超
 * @create 2021/6/6
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        log.info("param: " + payment);
        return restTemplate.postForObject("http://localhost:8001/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        log.info("param: " + id);
        return restTemplate.getForObject("http://localhost:8001/payment/get/" + id, CommonResult.class);
    }
}
