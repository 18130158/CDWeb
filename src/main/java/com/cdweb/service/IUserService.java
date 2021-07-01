package com.cdweb.service;

import com.cdweb.dto.UserDTO;

import java.util.List;

public interface IUserService {
    public UserDTO findByEmail(String userName);

    public UserDTO sendMail(UserDTO user);

    public UserDTO confirmEmail(String confirmationToken);

    public UserDTO sendMailForgetPassword(String email);

    public UserDTO confirmEmailForgetPassword(String token);

    UserDTO changePassword(UserDTO user);

    boolean checkPass(String password, String email);

    List<UserDTO> findAll();

    UserDTO save(UserDTO user);

    void delete(String email);
    UserDTO findEmail(String email);
}
