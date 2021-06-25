package com.cdweb.service;

import com.cdweb.dto.UserDTO;

public interface IUserService {
    public UserDTO findByEmail(String userName);
    public UserDTO sendMail(UserDTO user);
    public UserDTO confirmEmail(String confirmationToken);

    public UserDTO sendMailForgetPassword(String email);
    public UserDTO confirmEmailForgetPassword(String token);

    UserDTO changePassword(UserDTO user);

    boolean checkPass(String password, String email);
}
