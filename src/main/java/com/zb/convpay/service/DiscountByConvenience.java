package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;

public class DiscountByConvenience implements DiscountInterface{

    @Override
    public Integer getDiscountAmount(PayRequest payRequest) {
        switch(payRequest.getConvenienceType()){
            case G25:
                return payRequest.getPayAmount() * 8 / 10;
            case CU:
                return payRequest.getPayAmount() * 9 / 10;
            case SEVEN:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}
