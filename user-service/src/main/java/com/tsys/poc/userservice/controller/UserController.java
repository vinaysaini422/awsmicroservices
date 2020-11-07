package com.tsys.poc.userservice.controller;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.model.Response;
import com.tsys.poc.userservice.model.UserInfo;
import com.tsys.poc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userinfo")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> create(@RequestBody User user) {
		userService.add(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	@GetMapping("/readAll")
	public Iterable<User> readAll() {
		return userService.getAll();
	}

	@GetMapping("/read/{username}")
	public ResponseEntity<Response> readByUsername(@PathVariable(name = "username") String username) {
		Optional<User> user = userService.getById(username);
		Response returnData = new Response();
		if (user.isPresent()) {
			returnData.setReturnData(user.get());
			return ResponseEntity.status(HttpStatus.OK).body(returnData);
		} else {
			String msg = "Username not exist";
			returnData.setMessage(msg);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(returnData);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Response> update(@RequestBody UserInfo userInfo) {
		Response returnData = new Response();
		try {
			userService.updateUser(userInfo.getUser(), userInfo.getUpdatedUser());
			returnData.setMessage("Updated Successfully");
			returnData.setReturnData(userInfo.getUpdatedUser());
			return ResponseEntity.status(HttpStatus.OK).body(returnData);

		} catch (Exception e) {
			returnData.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(returnData);
		}
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<Response> deleteByUsername(@PathVariable(name = "username") String username) {
		Response returnData = new Response();
		try {
			userService.deleteById(username);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(returnData);
		} catch (Exception e) {
			returnData.setMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(returnData);
		}

	}

}
