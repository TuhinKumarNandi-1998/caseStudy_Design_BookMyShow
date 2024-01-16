package com.example.casestudy_design_book_my_show.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
    @ManyToOne
    private Region region;
}
