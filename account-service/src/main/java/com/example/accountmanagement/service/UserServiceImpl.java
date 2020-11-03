package com.example.accountmanagement.service;

import org.springframework.stereotype.Component;

import com.example.accountmanagement.modal.PasswordUpdateModel;
import com.example.accountmanagement.modal.ResponseModel;

@Component
public class UserServiceImpl implements UserService {

	@Override
	public void requestPasswordReset(String email, ResponseModel rM) {
		// TODO Auto-generated method stub
		rM.setOperationDescription("Mail sent");
		rM.setOperationResult("Success");
		
	}

	@Override
	public void updatePassword(PasswordUpdateModel update, ResponseModel rM) {
		// TODO Auto-generated method stub
		
	}

}
