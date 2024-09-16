package com.Quanh.dao;

import java.util.List;

import com.Quanh.model.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	UserModel findByUserName(String username);
}
