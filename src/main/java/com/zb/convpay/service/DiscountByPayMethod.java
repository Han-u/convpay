package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface{

    @Override
    public Integer getDiscountAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {
            case MONEY:
                return payRequest.getPayAmount() * 7 / 10;
            case CARD:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}