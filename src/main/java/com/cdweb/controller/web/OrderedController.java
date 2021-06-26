package com.cdweb.controller.web;

import com.cdweb.api.web.input.OrderedInput;
import com.cdweb.api.web.output.CartOutput;
import com.cdweb.dto.BookDTO;
import com.cdweb.dto.OrderedDTO;
import com.cdweb.dto.OrderedItemDTO;
import com.cdweb.dto.ShoppingCartDTO;
import com.cdweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderedController {
    @Autowired
    private IShoppingCartService shoppingCartService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IOrderedService orderedService;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IOrderItemService orderItemService;

    @PostMapping("/dat-hang")
    public ModelAndView payment(@ModelAttribute("orderedInput") OrderedInput orderedInput, Principal principal) {
        List<OrderedItemDTO> itemList = new ArrayList<>();
        double total_price = 0;
        for (Long s : orderedInput.getCarts()) {
            ShoppingCartDTO shoppingCartDTO = this.shoppingCartService.getId(s);
            double total = shoppingCartDTO.getBook().getPrice() * (1 - shoppingCartDTO.getBook().getDiscount() / 100) * shoppingCartDTO.getQuantity();
            total_price += total;
            OrderedItemDTO orderedItem = new OrderedItemDTO();
            orderedItem.setTotalPrice(total);
            orderedItem.setQuantity(shoppingCartDTO.getQuantity());
            orderedItem.setBook(shoppingCartDTO.getBook());
            itemList.add(orderedItem);
            this.shoppingCartService.delete(shoppingCartDTO);
        }
        OrderedDTO orderedDTO = new OrderedDTO();
        orderedDTO.setNowDate();
        orderedDTO.setReceiveDate(null);
        orderedDTO.setStatus("ĐANG XỬ LÝ");
        orderedDTO.setTotalPrice(total_price + 25000);
        orderedDTO.setName(orderedInput.getName());
        orderedDTO.setPhone(orderedInput.getPhone());
        orderedDTO.setAddress(orderedInput.getAddress());
        orderedDTO.setUser(this.userService.findByEmail(principal.getName()));

        OrderedDTO resultOrdered = this.orderedService.save(orderedDTO);

        for (OrderedItemDTO orderedItem : itemList) {
            orderedItem.setOrdered(resultOrdered);
            this.orderItemService.save(orderedItem);
            BookDTO book = orderedItem.getBook();
            book.setQuantity(book.getQuantity() - orderedItem.getQuantity());
            this.bookService.save(book);
        }
        return new ModelAndView("dat-hang-thanh-cong.html");
    }

    @PostMapping("/thanh-toan")
    public ModelAndView getPayment(@ModelAttribute("orderedInput") OrderedInput orderedInput, Principal principal) {
        if (principal == null) {
            return new ModelAndView("dang-nhap.html");
        }
        CartOutput cartOutput = new CartOutput();
        double total = 0;
        for (Long s : orderedInput.getCarts()) {
            ShoppingCartDTO shoppingCartDTO = this.shoppingCartService.getId(s);
            total += shoppingCartDTO.getBook().getPrice() * (1 - shoppingCartDTO.getBook().getDiscount() / 100) * shoppingCartDTO.getQuantity();
            cartOutput.getList().add(shoppingCartDTO);
        }
        cartOutput.setTotal(total);
        ModelAndView mav = new ModelAndView("thanh-toan.html");
        mav.addObject("output", cartOutput);
        mav.addObject("user", this.userService.findByEmail(principal.getName()));
        return mav;
    }

    @GetMapping("/don-hang")
    public List<OrderedDTO> getOrdered(Principal principal) {
        return this.orderedService.findAllOrder(principal.getName());
    }
}
