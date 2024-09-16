package com.Quanh.service;

import com.Quanh.model.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	 UserModel findByUsername(String username);
}
