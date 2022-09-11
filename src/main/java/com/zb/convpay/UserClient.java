package com.zb.convpay;

import com.zb.convpay.dto.PayCancelRequest;
import com.zb.convpay.dto.PayCancelResponse;
import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.dto.PayResponse;
import com.zb.convpay.service.ConveniencePayService;
import com.zb.convpay.type.ConvenienceType;
import com.zb.convpay.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 1. 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);

        // 2. 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}
