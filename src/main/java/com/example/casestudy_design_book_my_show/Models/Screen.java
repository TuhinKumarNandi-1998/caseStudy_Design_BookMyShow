package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
    @ManyToOne
    private Theatre theatre;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<ScreenFeatures> screenFeatures;
}
