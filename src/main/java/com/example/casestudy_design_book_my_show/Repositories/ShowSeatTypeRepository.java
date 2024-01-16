package com.example.casestudy_design_book_my_show.Repositories;

import com.example.casestudy_design_book_my_show.Models.SeatType;
import com.example.casestudy_design_book_my_show.Models.Show;
import com.example.casestudy_design_book_my_show.Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findAllByShow(Show show);
}
