package com.tsys.poc.userservice.service;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.model.PasswordUpdateModel;
import com.tsys.poc.userservice.model.ResponseModel;
import com.tsys.poc.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteById(String id) {
        Optional<User> deletedUser = getById(id);
        if (!deletedUser.isPresent()) {
            throw new EntityNotFoundException("username " + id + " does not exist.");
        }
        delete(deletedUser.get());
    }

    @Override
    public User updateUser(User user, User modifiedUser) {
        Optional<User> oldUser = getById(user.getUsername());
        if (!oldUser.isPresent()) {
            throw new EntityNotFoundException("User with username: " + user.getUsername() + " does not exist.");
        }
        if (!oldUser.get().equals(user)) {
            throw new EntityNotFoundException("Information of user to be updated is incorrect");
        }
        if (!user.getUsername().trim().toLowerCase().equals(modifiedUser.getUsername().trim().toLowerCase())) {
            throw new PersistenceException("Username of modified user object is not similar to existing user object.");
        }
        delete(oldUser.get());
        return add(modifiedUser);
    }

    @Override
    public void requestPasswordReset(String username, ResponseModel rM) {
        // TODO Auto-generated method stub
        Optional<User> userOptional = getById(username);
        if (userOptional.isPresent()) {
            //Send the mail with the tocken generated
            rM.setOperationDescription("Mail sent");
            rM.setOperationResult("Success");
        } else {
            rM.setOperationDescription("username not exist");
            rM.setOperationResult("error");
        }


    }

    @Override
    public void updatePassword(PasswordUpdateModel update, ResponseModel rM) {
        // TODO Auto-generated method stub

    }
}
