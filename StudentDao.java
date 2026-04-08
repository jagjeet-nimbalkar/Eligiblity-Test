package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;

public class StudentDao {
	private Connection conn;

	public StudentDao(Connection conn) {
		this.conn = conn;
	}
	
	public boolean addStudent(Student s) {
		boolean f=false;
		
		try {
			String sql="INSERT INTO Student(name,email) VALUES(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getEmail());
			ps.executeUpdate();
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}
	
	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		try {
			String sql = "SELECT * FROM student";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Student s = new Student(id ,name,email);
				list.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean deleteStudent(int id) {
		boolean f = false;
		try {
			String sql = "DELETE FROM student WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

}
