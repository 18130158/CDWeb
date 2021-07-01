package com.cdweb.controller.admin;

import com.cdweb.api.web.input.AddBookInput;
import com.cdweb.api.web.input.UserInput;
import com.cdweb.converter.RoleConverter;
import com.cdweb.dto.*;
import com.cdweb.entity.BookEntity;
import com.cdweb.entity.RoleEntity;
import com.cdweb.repository.RoleRepository;
import com.cdweb.service.IBookService;
import com.cdweb.service.ICategoryService;
import com.cdweb.service.IOrderedService;
import com.cdweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@RestController
public class AdminController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IOrderedService orderedService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConverter roleConverter;


    //    PRODUCT   //


    @GetMapping("/admin")
    public ModelAndView listProduct(Principal principal) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("user@gmail.com");
        userDTO.setPassword(encoder.encode("123"));
        userDTO.setEnabled(true);
        RoleEntity role = this.roleRepository.findByName("ROLE_USER");
        List<RoleDTO> roleDTOS = new ArrayList<>();
        roleDTOS.add(roleConverter.toDTO(role));
        userDTO.setRoleList(roleDTOS);
        userService.save(userDTO);

        RoleEntity roleAdmin = this.roleRepository.findByName("ROLE_ADMIN");
        roleDTOS.add(roleConverter.toDTO(roleAdmin));
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setEmail("admin@gmail.com");
        userDTO1.setPassword(encoder.encode("123"));
        userDTO1.setEnabled(true);
        userDTO1.setRoleList(roleDTOS);
        userService.save(userDTO1);


        ModelAndView mav = new ModelAndView("admin/index.html");
        mav.addObject("listbook", bookService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping("/admin-productAdd")
    public ModelAndView addProductPage(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/product-add.html");
        mav.addObject("listcategory", categoryService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @PostMapping("/admin-productAdd")
    public ModelAndView addProduct(@ModelAttribute("AddBookInput") AddBookInput bookInput, Principal principal) {
        Path staticPath = Paths.get("src/main/resources/static");
        Path imagePath = Paths.get("admin/img/bookupload");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            try {
                Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(bookInput.getImages().getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(bookInput.getImages().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookInput.getId());
        bookDTO.setTitle(bookInput.getTitle());
        bookDTO.setShortDescription(bookInput.getShortDescription());
        bookDTO.setDescription(bookInput.getDescription());
        bookDTO.setDiscount(bookInput.getDiscount());
        bookDTO.setPrice(bookInput.getPrice());
        bookDTO.setQuantity(bookInput.getQuantity());
        bookDTO.setPage(bookInput.getPage());
        bookDTO.setNewBook(bookInput.isNewBook());
        bookDTO.setHotBook(bookInput.isHotBook());
        bookDTO.setPublisher(bookInput.getPublisher());
        bookDTO.setActive(true);
        bookDTO.setCategory(this.categoryService.findCategory(bookInput.getCategory()));
        List<MediaDTO> medias = new ArrayList<>();
        MediaDTO media = new MediaDTO();
        StringTokenizer stringTokenizer = new StringTokenizer(imagePath.resolve(bookInput.getImages().getOriginalFilename()).toString(), "\\");
        String s = "";
        while (stringTokenizer.hasMoreTokens()) {
            s += stringTokenizer.nextToken() + "/";
        }
        media.setPath(s.substring(0, s.length() - 1));
        medias.add(media);
        bookDTO.setMediaList(medias);

        BookDTO book = bookService.save(bookDTO);

        ModelAndView mav = new ModelAndView("admin/index.html");
        mav.addObject("listbook", bookService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }


    @GetMapping("/admin-productEdit")
    public ModelAndView editProductPage(@Param("id") long id, Principal principal) {
        ModelAndView mav = new ModelAndView("admin/product-edit.html");
        mav.addObject("listcategory", categoryService.findAll());
        mav.addObject("product", bookService.findById(id));
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping("/admin-productDelete")
    public ModelAndView deleteProductPage(@Param("id") long id, Principal principal) {
        ModelAndView mav = new ModelAndView("admin/index.html");
        mav.addObject("listcategory", categoryService.findAll());
        long[] ids = {id};
        bookService.delete(ids);
        mav.addObject("listbook", bookService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    //    PRODUCT   //

    //    CATEGORY    //

    @GetMapping("/admin-listCategory")
    public ModelAndView listCategory(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/productType.html");
        mav.addObject("listcategory", categoryService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping("/admin-addType")
    public ModelAndView addCategory(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/productType-add.html");
        mav.addObject("category", new CategoryDTO());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @RequestMapping(value = "/admin-addType", method = RequestMethod.POST)
    public ModelAndView addType(@ModelAttribute("category") CategoryDTO category, Principal principal) {
        categoryService.save(category);
        ModelAndView mav = new ModelAndView("admin/productType.html");
        mav.addObject("listcategory", categoryService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    //    CATEGORY    //

    //    ORDER  //

    @GetMapping("/admin-listOrder")
    public ModelAndView listOrder(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/cart");
        mav.addObject("listOrders", orderedService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping("/admin-orderDetail")
    public ModelAndView orderDetail(@PathVariable("id") long id, Principal principal) {
        ModelAndView mav = new ModelAndView("admin/cart-detail.html");
        mav.addObject("order", orderedService.findOrder(id));
        mav.addObject("username", principal.getName());
        return mav;
    }


    // CUSTOMER//

    @GetMapping("/admin-listCustomer")
    public ModelAndView listCustomer(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/customer.html");
        mav.addObject("listAllUser", userService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping(value = "/admin-addUser")
    public ModelAndView getAddUserPage(Principal principal) {
        ModelAndView mav = new ModelAndView("admin/customer-add.html");
        mav.addObject("userinput", new UserInput());
        mav.addObject("username", principal.getName());
        return mav;
    }


    @RequestMapping(value = "/admin-addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userinput") UserInput userinput, Principal principal) {
        UserDTO user = new UserDTO();
        List<RoleDTO> roleDTO = new ArrayList<>();
        for (String s : userinput.getRole()) {
            roleDTO.add(this.roleConverter.toDTO(this.roleRepository.findByName(s)));
        }
        user.setEmail(userinput.getEmail());
        user.setPassword(userinput.getPassword());
        user.setFullName(userinput.getFullName());
        user.setPhone(userinput.getPhone());
        user.setAddress(userinput.getAddress());
        if (userinput.getIsEnabled().equals("true")) {
            user.setEnabled(true);
        }
        user.setRoleList(roleDTO);
        userService.save(user);
        ModelAndView mav = new ModelAndView("admin/customer.html");
        mav.addObject("listAllUser", userService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping(value = "/admin-editUser")
    public ModelAndView editUserPage(@Param("email") String email, Principal principal) {
        ModelAndView mav = new ModelAndView("admin/customer-edit.html");
        mav.addObject("user", userService.findEmail(email));
        mav.addObject("useremail", email);
        mav.addObject("username", principal.getName());
        return mav;
    }

    @GetMapping(value = "/admin-deleteUser")
    public ModelAndView deleteUserPage(@Param("email") String email, Principal principal) {

        this.userService.delete(email);

        ModelAndView mav = new ModelAndView("admin/customer.html");
        mav.addObject("listAllUser", userService.findAll());
        return mav;
    }

    @RequestMapping(value = "/admin-editUser", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("userinput") UserInput userinput, Principal principal) {
        UserDTO user = new UserDTO();
        List<RoleDTO> roleDTO = new ArrayList<>();
        for (String s : userinput.getRole()) {
            roleDTO.add(this.roleConverter.toDTO(this.roleRepository.findByName(s)));
        }
        user.setEmail(userinput.getEmail());
        user.setPassword(userinput.getPassword());
        user.setFullName(userinput.getFullName());
        user.setPhone(userinput.getPhone());
        user.setAddress(userinput.getAddress());
        if (userinput.getIsEnabled().equals("true")) {
            user.setEnabled(true);
        }
        user.setRoleList(roleDTO);

        this.userService.changePassword(user);
        ModelAndView mav = new ModelAndView("admin/customer.html");
        mav.addObject("listAllUser", userService.findAll());
        mav.addObject("username", principal.getName());
        return mav;
    }
}
