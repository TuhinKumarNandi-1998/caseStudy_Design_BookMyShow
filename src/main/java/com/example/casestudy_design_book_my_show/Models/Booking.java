package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Booking extends BaseModel {
    @ManyToOne
    @CreatedBy
    private User user;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Payment> payments;
    private double price;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToMany
    private List<ShowSeat> seats;
    private Date timeOfBooking;
}
