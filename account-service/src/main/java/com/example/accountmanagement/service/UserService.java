package com.example.accountmanagement.service;

import org.springframework.stereotype.Component;

import com.example.accountmanagement.modal.PasswordUpdateModel;
import com.example.accountmanagement.modal.ResponseModel;

@Component
public interface UserService {

	 void requestPasswordReset(String email, ResponseModel rM);
	 
	 void updatePassword(PasswordUpdateModel update, ResponseModel rM);

}
