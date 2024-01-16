package com.example.casestudy_design_book_my_show.Controllers;

import com.example.casestudy_design_book_my_show.Models.Booking;
import com.example.casestudy_design_book_my_show.Services.BookingService;
import com.example.casestudy_design_book_my_show.dtos.BookMovieRequestDTO;
import com.example.casestudy_design_book_my_show.dtos.BookMovieResponseDTO;
import com.example.casestudy_design_book_my_show.dtos.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO) {
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();

        try {
            Booking booking = bookingService.bookMovie(
                    bookMovieRequestDTO.getSeatID(),
                    bookMovieRequestDTO.getUserID(),
                    bookMovieRequestDTO.getShowID()
            );

            responseDTO.setBookingID(booking.getId());
            responseDTO.setPrice(booking.getPrice());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
