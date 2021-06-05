package com.cdweb.service;

import com.cdweb.dto.UserDTO;

public interface IUserService extends  IGeneralService<UserDTO> {
    public UserDTO findByEmail(String userName);
    public UserDTO sendMail(UserDTO user);
    public UserDTO confirmEmail(String confirmationToken);
}
