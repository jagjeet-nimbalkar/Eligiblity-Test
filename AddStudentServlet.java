package com.student.servlet;

import java.io.IOException;

import com.student.dao.StudentDao;
import com.student.db.DBConnect;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		Student s=new Student(name,email);
		StudentDao dao=new StudentDao(DBConnect.getConnection());
		if(dao.addStudent(s)) {
			resp.sendRedirect("index.jsp");
		}
	}
}
