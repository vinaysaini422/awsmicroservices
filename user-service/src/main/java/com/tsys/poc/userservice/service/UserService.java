package com.tsys.poc.userservice.service;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.repository.UserLoginInfoRepository;
import com.tsys.poc.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserLoginInfoRepository userLoginInfoRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserLoginInfoRepository userLoginInfoRepository) {
        this.userRepository = userRepository;
        this.userLoginInfoRepository = userLoginInfoRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public User getById(String id) {
        return userRepository.getOne(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User delete(User user) {
        userRepository.delete(user);
        return user;
    }

    public User deleteById(String id) {
        User deletedUser = getById(id);
        if (deletedUser == null) {
            throw new EntityNotFoundException("User with username: " + id + " does not exist.");
        }
        delete(deletedUser);
        return deletedUser;
    }

    public User updateUser(User user, User modifiedUser) {
        User oldUser = getById(user.getUsername());
        if (oldUser == null) {
            throw new EntityNotFoundException("User with username: " + user.getUsername() + " does not exist.");
        }
        if (!oldUser.equals(user)) {
            throw new EntityNotFoundException("Information of user to be updated is incorrect");
        }
        if (!user.getUsername().trim().toLowerCase().equals(modifiedUser.getUsername().trim().toLowerCase())) {
            throw new PersistenceException("Username of modified user object is not similar to existing user object.");
        }
        delete(oldUser);
        return add(modifiedUser);
    }
}
