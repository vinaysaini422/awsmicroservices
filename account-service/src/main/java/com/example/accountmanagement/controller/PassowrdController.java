package com.example.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accountmanagement.modal.Constants;
import com.example.accountmanagement.modal.PasswordRequestModel;
import com.example.accountmanagement.modal.PasswordUpdateModel;
import com.example.accountmanagement.modal.ResponseModel;
import com.example.accountmanagement.service.UserService;

@RestController
@RequestMapping("/password")
public class PassowrdController {

	@Autowired
	UserService userService;

	@PostMapping("/reset")
	ResponseEntity<ResponseModel> resetPassword(@RequestBody PasswordRequestModel passwordRequestModel) {
		ResponseModel rM = new ResponseModel();

		userService.requestPasswordReset(passwordRequestModel.getEmail(), rM);
		rM.setOperationName(Constants.PASSWORD_RESET.name());
		return ResponseEntity.status(HttpStatus.CREATED).body(rM);
	}

	@PutMapping("/reset")
	ResponseEntity<ResponseModel> updatePassword(@RequestBody PasswordUpdateModel passwordUpdateModel) {
		ResponseModel rM = new ResponseModel();

		userService.updatePassword(passwordUpdateModel, rM);
		rM.setOperationName(Constants.PASSWORD_UPDATE.name());
		return ResponseEntity.status(HttpStatus.CREATED).body(rM);
	}
}
