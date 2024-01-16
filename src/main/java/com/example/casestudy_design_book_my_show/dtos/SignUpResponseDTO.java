package com.example.casestudy_design_book_my_show.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private long userID;
    private ResponseStatus responseStatus;
}
