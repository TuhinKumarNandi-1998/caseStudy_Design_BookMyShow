package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private double price;
    private String transactionID;
    private Date timeOfPayment;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.ORDINAL)
    private PaymentGatewayProvider paymentGatewayProvider;
}
