package com.examination.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examination.database.MyDBConnection;
import com.examination.models.Marks;
import com.examination.models.StudMarks;

public class MarksCrud {
	
	public static Boolean insertMarks(Marks marks) {
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("insert into marks values(?,?)");
		try {
			st.setString(1, marks.getSid());
			st.setInt(2, marks.getMarks());
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
	
	public static Boolean updateMarks(Marks marks) {
		MyDBConnection conn = new MyDBConnection();
		Boolean flag = false;
		PreparedStatement st = conn.getPreparedStatement("update marks set marks=? where sid=?");
		try {
			st.setInt(1, marks.getMarks());
			st.setString(2, marks.getSid());
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
	
	public static Marks getMarksBySid(String sid) {

		Marks marks = new Marks();
		MyDBConnection conn = new MyDBConnection();
		PreparedStatement st = conn.getPreparedStatement("select * from marks where sid = ?");
		try {
			st.setString(1, sid);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				marks.setSid(rs.getString("sid"));
				marks.setMarks(rs.getInt("marks"));
			}else {
				marks.setSid("none");
				marks.setMarks(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
	
		return marks;
	}
	
	public static List<StudMarks> getStudMarksList() {

		List<StudMarks> marksList = new ArrayList<StudMarks>();
		MyDBConnection conn = new MyDBConnection();
		PreparedStatement st = conn.getPreparedStatement("select m.*, u.name  from marks m, users u where m.sid=u.userid");
		try {
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				StudMarks marks = new StudMarks(rs.getString("sid"), rs.getInt("marks"), rs.getString("name"));
				marksList.add(marks);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.closeConnection();
		}
	
		return marksList;
	}
	
	public static Boolean registerMarks(Marks marks) {
		Marks m = getMarksBySid(marks.getSid());
		if (m.getSid().equals("none")) {
			return insertMarks(marks);
		}else {
			return updateMarks(marks);
		}
	}
	
	
}
