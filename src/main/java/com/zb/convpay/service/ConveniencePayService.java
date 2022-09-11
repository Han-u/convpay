package com.zb.convpay.service;

import com.zb.convpay.dto.PayCancelRequest;
import com.zb.convpay.dto.PayCancelResponse;
import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.dto.PayResponse;
import com.zb.convpay.type.*;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        PaymentResult payment = paymentInterface.payment(payRequest.getPayAmount());

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }


        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
