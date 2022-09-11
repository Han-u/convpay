package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.dto.PayResponse;
import com.zb.convpay.dto.PayResult;

public class ConveniencePayService {
    public PayResponse pay(PayRequest payRequest) {
        return new PayResponse(PayResult.SUCCESS, 100);
    }

    public void payCancel() {

    }
}
