package com.example.casestudy_design_book_my_show.Repositories;

import com.example.casestudy_design_book_my_show.Models.Show;
import com.example.casestudy_design_book_my_show.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findAllById(List<Long> showSeatIDs);

    ShowSeat save(ShowSeat showSeat);
}
