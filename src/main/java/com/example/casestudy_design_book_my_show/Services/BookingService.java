package com.example.casestudy_design_book_my_show.Services;

import com.example.casestudy_design_book_my_show.Exceptions.ShowNotFoundException;
import com.example.casestudy_design_book_my_show.Exceptions.ShowSeatNotAvailableException;
import com.example.casestudy_design_book_my_show.Exceptions.UserNotFoundException;
import com.example.casestudy_design_book_my_show.Models.*;
import com.example.casestudy_design_book_my_show.Repositories.ShowRepository;
import com.example.casestudy_design_book_my_show.Repositories.ShowSeatRepository;
import com.example.casestudy_design_book_my_show.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculator priceCalculator;

    @Autowired
    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculator priceCalculator) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculator = priceCalculator;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(List<Long> showSeatIDs, Long userID, Long showID) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userID);

        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id "+userID+" not found");
        }
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showID);

        if(optionalShow.isEmpty()) {
            throw new ShowNotFoundException("Show with showID "+showID+" not found");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIDs); //got all the showSeats for that particular show


        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getSeatStatus().equals(SeatStatus.AVAILABLE)) {
                throw new ShowSeatNotAvailableException("ShowSeat with id "+showSeat.getId()+" not available");
            }
        }

        List<ShowSeat> finalShowSeats = new ArrayList<>();
        //All showSeats are available
        for(ShowSeat showSeat : showSeats) {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            finalShowSeats.add(showSeatRepository.save(showSeat));
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShow(show);
        booking.setSeats(finalShowSeats);
        booking.setUser(user);
        booking.setTimeOfBooking(new Date());
        booking.setPayments(new ArrayList<>());
        booking.setPrice(priceCalculator.calculatePrice(show, finalShowSeats));

        return booking;
    }
}
