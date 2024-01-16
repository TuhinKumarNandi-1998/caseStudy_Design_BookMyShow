package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private Double price;
}
