package com.Quanh.service.impl;

import com.Quanh.model.UserModel;
import com.Quanh.service.IUserService;
import com.Quanh.dao.impl.UserDaoImpl;
import com.Quanh.dao.IUserDao;

public class UserServiceImpl implements IUserService {
	//lấy tất cả hàm trong tầng Dao
	IUserDao userDao = new UserDaoImpl();
	

	@Override
	public UserModel login(String username, String password) {
		
		UserModel user = this.findByUsername(username);
		 
		if (user != null && password.equals(user.getPassword())) {
			 return user;
		 }
		 return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		
		return userDao.findByUserName(username);
	}
	public static void main(String[] args) {
	 	
        IUserService userDao = new UserServiceImpl();
        System.out.println(userDao.findByUsername("trungnh"));
        //List<UserModel> list = userDao.findAll();
       // for (UserModel user : list) {
       //     System.out.println(user);
       // }
    }
}