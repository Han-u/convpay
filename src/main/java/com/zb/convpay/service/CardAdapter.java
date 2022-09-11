package com.zb.convpay.service;

import com.zb.convpay.type.CardUseCancelResult;
import com.zb.convpay.type.CardUseResult;

public class CardAdapter {
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
}
