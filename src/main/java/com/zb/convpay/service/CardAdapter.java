package com.zb.convpay.service;

import com.zb.convpay.type.CancelPaymentResult;
import com.zb.convpay.type.CardUseCancelResult;
import com.zb.convpay.type.CardUseResult;
import com.zb.convpay.type.PaymentResult;

public class CardAdapter implements PaymentInterface{
    // 1. 인증
    public void authorization(){
        System.out.println("authorization success");
    }

    // 2. 승인
    public void approval(){
        System.out.println("approval success");
    }

    // 3. 메일
    public CardUseResult capture(Integer payAmount){
        if(payAmount > 100){
            return CardUseResult.USE_FAIL;
        }
        return CardUseResult.USE_SUCCESS;
    }

    // 4. 메일 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount){
        if(cancelAmount < 1000){
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }
        return CardUseCancelResult.USE_CANCEL_SUCCESS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);

        if(cardUseResult == CardUseResult.USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);

        if(cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL){
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }
        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
