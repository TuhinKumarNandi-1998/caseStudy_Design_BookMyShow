package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    private String movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;
    private String language;
}
