package com.zb.convpay.service;

import com.zb.convpay.type.CancelPaymentResult;
import com.zb.convpay.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
