package com.zb.convpay.service;

import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.type.ConvenienceType;
import com.zb.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test
    void discountTest() {
        //given
        PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequest payRequestCU = new PayRequest(PayMethodType.MONEY, ConvenienceType.CU, 1000);
        PayRequest payRequestSeven = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);

        //when
        Integer discountAmountG25 = discountByConvenience.getDiscountAmount(payRequestG25);
        Integer discountAmountCU = discountByConvenience.getDiscountAmount(payRequestCU);
        Integer discountAmountSeven = discountByConvenience.getDiscountAmount(payRequestSeven);

        //then
        assertEquals(800, discountAmountG25);
        assertEquals(900, discountAmountCU);
        assertEquals(1000, discountAmountSeven);
    }


}