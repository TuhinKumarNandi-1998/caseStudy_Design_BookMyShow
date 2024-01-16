package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "seats")
public class Seat extends BaseModel {
    private int rowNum;
    private int colNum;
    private int seatNo;
    @ManyToOne
    private SeatType seatType;
    @ManyToOne
    private Screen screen;
}
