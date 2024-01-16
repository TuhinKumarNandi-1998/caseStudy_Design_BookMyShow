package com.example.casestudy_design_book_my_show.Services;

import com.example.casestudy_design_book_my_show.Models.Show;
import com.example.casestudy_design_book_my_show.Models.ShowSeat;
import com.example.casestudy_design_book_my_show.Models.ShowSeatType;
import com.example.casestudy_design_book_my_show.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public Double calculatePrice(Show show, List<ShowSeat> showSeats) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        double price = 0;
        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    price += showSeatType.getPrice();
                    break;
                }
            }
        }
        return price;
    }
}
