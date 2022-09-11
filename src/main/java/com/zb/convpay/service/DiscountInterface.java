package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountAmount(PayRequest payRequest);

}
