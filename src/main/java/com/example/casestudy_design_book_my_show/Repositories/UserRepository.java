package com.example.casestudy_design_book_my_show.Repositories;

import com.example.casestudy_design_book_my_show.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);

    Optional<User> findByEmail(String email);

    User save(User user);
}
