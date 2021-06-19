package com.cdweb.service.impl;

import com.cdweb.controller.web.BookController;
import com.cdweb.converter.OrderedItemConverter;
import com.cdweb.dto.OrderedItemDTO;
import com.cdweb.dto.UserDTO;
import com.cdweb.repository.OrderedItemRepository;
import com.cdweb.service.IBookService;
import com.cdweb.service.IOrderItemService;
import com.cdweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Service
public class OrderedItemServiceImpl implements IOrderItemService {
    @Autowired
    private OrderedItemRepository orderedItemRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private OrderedItemConverter orderedItemConverter;
    @Autowired
    private IBookService bookService;

    @Override
    public int addProduct(long book_id, Principal principal) {
        UserDTO user=this.userService.findByEmail(principal.getName());
        OrderedItemDTO orderedItem=this.orderedItemConverter.toDTO(this.orderedItemRepository.findItem(book_id, user.getId()));
        if (orderedItem==null){
            OrderedItemDTO orderedItemNew=new OrderedItemDTO();
            orderedItemNew.setBookDTO(this.bookService.findById(book_id));
//            orderedItemNew.setOrderedDTO();
        }


        return 0;
    }
}
