package com.example.casestudy_design_book_my_show.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private Long bookingID;
    private Double price;
    private ResponseStatus responseStatus;
}
