package com.tsys.poc.userservice.service;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.model.PasswordUpdateModel;
import com.tsys.poc.userservice.model.ResponseModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserService {

    public User add(User user);

    public Optional<User> getById(String id);

    public Iterable<User> getAll();

    public void delete(User user);

    public void deleteById(String id);

    public User updateUser(User user, User modifiedUser);

    void requestPasswordReset(String email, ResponseModel rM);

    void updatePassword(PasswordUpdateModel update, ResponseModel rM);

}
