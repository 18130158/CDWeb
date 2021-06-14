package com.cdweb.service.impl;

import com.cdweb.converter.RoleConverter;
import com.cdweb.converter.UserConverter;
import com.cdweb.dto.RoleDTO;
import com.cdweb.dto.UserDTO;
import com.cdweb.entity.ConfirmationToken;
import com.cdweb.entity.RoleEntity;
import com.cdweb.entity.UserEntity;
import com.cdweb.repository.ConfirmationTokenRepository;
import com.cdweb.repository.RoleRepository;
import com.cdweb.repository.UserRepository;
import com.cdweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConverter roleConverter;

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity user = this.userRepository.findByEmail(userDTO.getEmail());
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    public void delete(long[] ids) {
    }

    @Override
    public UserDTO findByEmail(String email) {
        UserEntity userEntity = this.userRepository.findByEmail(email);
        if (userEntity != null) {
            return this.userConverter.toDTO(userEntity);
        }
        return null;
    }

    public UserDTO sendMail(UserDTO user) {
        UserEntity userEntity = new UserEntity();
        UserEntity existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
        if (existingUser != null) {
            return null;
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
            List<RoleDTO> list = new ArrayList<>();
            RoleEntity role = roleRepository.findByName("ROLE_USER");
            list.add(roleConverter.toDTO(role));
            user.setRoleList(list);
            UserEntity test = this.userConverter.toEntity(user);
            userEntity = userRepository.save(test);

            ConfirmationToken confirmationToken = new ConfirmationToken(userEntity);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("bookstore@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);
            return userConverter.toDTO(userEntity);
        }
    }

    @Override
    public UserDTO confirmEmail(String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null) {
            UserDTO user = userConverter.toDTO(userRepository.findByEmailIgnoreCase(token.getUser().getEmail()));
            user.setEnabled(true);
            UserEntity userEntity = userRepository.save(userConverter.toEntity(user));
//            userRepository.deleteById(user.getId());
            return userConverter.toDTO(userEntity);
        } else {
            return null;
        }
    }
}
