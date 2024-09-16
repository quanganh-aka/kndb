package com.Quanh.dao.impl;

import java.awt.desktop.UserSessionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Quanh.configs.DBConnectionSQL;
import com.Quanh.dao.IUserDao;
import com.Quanh.model.UserModel;

public class UserDaoImpl extends DBConnectionSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<>(); //tao 1 list de truyen dl
		try {
			conn = super.getConnection(); // ket noi database
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next() /*Next tung DONG toi cuoi bang*/) {
				list.add(
						new UserModel(
								rs.getInt("id"), 
								rs.getString("username"), 
								rs.getString("password"), 
								rs.getString("images"),
								rs.getString("fullname"), 
								rs.getString("email"), 
								rs.getString("phone"),
								rs.getInt("roleid"),
								rs.getDate("createdDate")
								)
						); 
			}
			return list;
		} catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE id = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users(id, username, password, images, fullname, email, phone, roleid, createdDate)";
		try {
			conn = super.getConnection(); // ket noi database
			ps = conn.prepareStatement(sql); //nem cau query vao cho thuc thi
			
			ps.setInt(1,  user.getId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getImages());
			ps.setString(5, user.getFullname());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getPhone());
			ps.setInt(8,  user.getRoleid());
			ps.setDate(9, user.getCreatedDate());
			
			ps.executeUpdate();
		} catch (Exception e){
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public UserModel findByUserName(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery(); 
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedDate(rs.getDate("createdDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Test findAll
	public static void main(String[] args) {
		
		UserDaoImpl userDao = new UserDaoImpl();
		
		List<UserModel> list = userDao.findAll();
		for(UserModel user : list) {
			System.out.println(user);
		}
	}

}