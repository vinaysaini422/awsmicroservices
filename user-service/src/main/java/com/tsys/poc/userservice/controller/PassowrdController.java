package com.tsys.poc.userservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.poc.userservice.config.JWTValidator;
import com.tsys.poc.userservice.model.Constants;
import com.tsys.poc.userservice.model.PasswordRequestModel;
import com.tsys.poc.userservice.model.PasswordUpdateModel;
import com.tsys.poc.userservice.model.ResponseModel;
import com.tsys.poc.userservice.service.UserService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/passwordReset")
@AllArgsConstructor
public class PassowrdController {

	UserService userService;
	
	private JWTValidator jWTValidator;
	

	@PostMapping("/request")
	ResponseEntity<ResponseModel> resetPassword(@RequestBody PasswordRequestModel passwordRequestModel) {
		ResponseModel rM = new ResponseModel();
		
		userService.requestPasswordReset(passwordRequestModel.getUsername(), rM);
		rM.setOperationName(Constants.PASSWORD_RESET.name());
		return ResponseEntity.status(HttpStatus.CREATED).body(rM);
	}

	@PutMapping("/update")
	ResponseEntity<ResponseModel> updatePassword(@RequestBody PasswordUpdateModel passwordUpdateModel, HttpServletRequest request) {
		ResponseModel rM = new ResponseModel();
		if (!jWTValidator.validateToken(request)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		userService.updatePassword(passwordUpdateModel, rM);
		rM.setOperationName(Constants.PASSWORD_UPDATE.name());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rM);
	}
}
