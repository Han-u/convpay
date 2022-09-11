package com.zb.convpay.config;

import com.zb.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class ApplicationConfig {
//    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
//        return new ConveniencePayService(
//                new HashSet<>(
//                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
//                ),
//                new DiscountByConvenience()
//        );
//    }
//
//    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
//        return new ConveniencePayService(
//                new HashSet<>(
//                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
//                ),
//                new DiscountByPayMethod()
//        );
//    }

    @Bean
    public ConveniencePayService conveniencePayService(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(moneyAdapter(), cardAdapter())
                ),
                discountByConvenience()
        );
    }

    @Bean
    public CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public DiscountByConvenience discountByConvenience(){
        return new DiscountByConvenience();
    }
}
