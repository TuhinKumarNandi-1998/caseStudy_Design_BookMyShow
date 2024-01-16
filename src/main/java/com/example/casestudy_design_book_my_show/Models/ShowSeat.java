package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
