package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.type.ConvenienceType;
import com.zb.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();
    
    @Test
    void discountSuccess() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD, ConvenienceType.G25, 1000);
        
        //when
        Integer discountAmountMoney = discountByPayMethod.getDiscountAmount(payRequestMoney);
        Integer discountAmountCard = discountByPayMethod.getDiscountAmount(payRequestCard);

        //then
        assertEquals(700, discountAmountMoney);
        assertEquals(1000, discountAmountCard);
    }
    

}