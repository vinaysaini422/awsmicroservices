package com.tsys.poc.userservice.service;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.model.PasswordUpdateModel;
import com.tsys.poc.userservice.model.ResponseModel;
import com.tsys.poc.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User add(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(String id) {
		return userRepository.getOne(id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User delete(User user) {
		userRepository.delete(user);
		return user;
	}

	@Override
	public User deleteById(String id) {
		User deletedUser = getById(id);
		if (deletedUser == null) {
			throw new EntityNotFoundException("User with username: " + id + " does not exist.");
		}
		delete(deletedUser);
		return deletedUser;
	}

	@Override
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

	@Override
	public void requestPasswordReset(String username, ResponseModel rM) {
		// TODO Auto-generated method stub
		rM.setOperationDescription("Mail sent");
		rM.setOperationResult("Success");

	}

	@Override
	public void updatePassword(PasswordUpdateModel update, ResponseModel rM) {
		// TODO Auto-generated method stub

	}
}
