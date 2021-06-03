package com.cdweb.dto;

public class ShoppingCartDTO extends AbstractDTO<ShoppingCartDTO> {
    private UserDTO userDTO;
    private BookDTO bookDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }
}
