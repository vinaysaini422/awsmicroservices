package com.tsys.poc.userservice.service;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.model.PasswordUpdateModel;
import com.tsys.poc.userservice.model.ResponseModel;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface UserService {

	public User add(User user);

	public User getById(String id);

	public List<User> getAll();

	public User delete(User user);

	public User deleteById(String id);

	public User updateUser(User user, User modifiedUser);

	void requestPasswordReset(String email, ResponseModel rM);

	void updatePassword(PasswordUpdateModel update, ResponseModel rM);

}
