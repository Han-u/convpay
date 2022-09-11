package com.zb.convpay.service;

import com.zb.convpay.dto.PayCancelRequest;
import com.zb.convpay.dto.PayCancelResponse;
import com.zb.convpay.dto.PayRequest;
import com.zb.convpay.dto.PayResponse;
import com.zb.convpay.type.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class ConveniencePayService {
//    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
//    private final CardAdapter cardAdapter = new CardAdapter();
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet, DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPayMethodType(),
                        paymentInterface
                )
        );
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());

        Integer discountedAmount = discountInterface.getDiscountAmount(payRequest);
        PaymentResult payment = paymentInterface.payment(discountedAmount);

        if (payment == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);

    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
