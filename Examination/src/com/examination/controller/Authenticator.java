package com.examination.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.examination.database.MyDBConnection;
import com.examination.models.Users;

public class Authenticator {
	
	public static Users login(String username, String password) {
		ResultSet rs;
		Users user = new Users();
		MyDBConnection conn = new MyDBConnection();
		PreparedStatement st = conn.getPreparedStatement("select * from users where username=? and password=?");
		try {
			st.setString(1, username);
			st.setString(2, password);
			rs = st.executeQuery();
			if (rs.next()) {
				
				user.setUserid(rs.getString("userid"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
		
		return user;
	}
	
	public static Boolean registration(Users user) {
		
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("insert into users values(?,?,?,?,?)");
		try {
			st.setString(1, user.getUserid());
			st.setString(2, user.getName());
			st.setString(3, user.getUsername());
			st.setString(4, user.getPassword());
			st.setString(5, user.getRole());
			st.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
		
		return flag;
		
	}
	
	
}
