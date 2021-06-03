package com.cdweb.dto;

public class CommentDTO extends  AbstractDTO<CommentDTO>{
    private UserDTO userDTO;
    private BookDTO bookDTO;
    private String review;

    public CommentDTO() {
    }

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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
