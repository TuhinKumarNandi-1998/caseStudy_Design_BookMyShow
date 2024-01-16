package com.example.casestudy_design_book_my_show.Controllers;

import com.example.casestudy_design_book_my_show.Models.User;
import com.example.casestudy_design_book_my_show.Services.UserService;
import com.example.casestudy_design_book_my_show.dtos.ResponseStatus;
import com.example.casestudy_design_book_my_show.dtos.SignUpRequestDTO;
import com.example.casestudy_design_book_my_show.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO signUp(SignUpRequestDTO requestDTO) {
        SignUpResponseDTO signUpResponseDTO = new SignUpResponseDTO();
        try {
            User user = userService.signUp(requestDTO.getEmailID(), requestDTO.getPassword());
            signUpResponseDTO.setUserID(user.getId());
            signUpResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            signUpResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }

        return signUpResponseDTO;
    }
}
