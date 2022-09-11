package com.zb.convpay;

import com.zb.convpay.config.ApplicationConfig;
import com.zb.convpay.dto.PayCancelRequest;
import com.zb.convpay.dto.PayCancelResponse;
import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.dto.PayResponse;
import com.zb.convpay.service.ConveniencePayService;
import com.zb.convpay.type.ConvenienceType;
import com.zb.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountPayMethod();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService = applicationContext.getBean("conveniencePayService", ConveniencePayService.class);

        // 1. 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 2. 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
