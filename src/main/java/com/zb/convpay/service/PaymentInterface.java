package com.zb.convpay.service;

import com.zb.convpay.type.CancelPaymentResult;
import com.zb.convpay.type.PayMethodType;
import com.zb.convpay.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
