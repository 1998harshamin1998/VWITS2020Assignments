package com.examination.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.examination.database.MyDBConnection;
import com.examination.models.Users;

public class UsersCrud {
	
	public static Boolean updateUser(Users user) {
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("update users set username=?, password=? where userid=?");
		try {
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getUserid());
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
