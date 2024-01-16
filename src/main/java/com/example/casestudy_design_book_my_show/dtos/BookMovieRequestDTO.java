package com.example.casestudy_design_book_my_show.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDTO {
    private Long userID;
    private Long showID;
    private List<Long> seatID;
}
