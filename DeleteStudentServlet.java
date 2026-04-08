package com.student.servlet;

import java.io.IOException;
import java.rmi.ServerException;

import com.student.dao.StudentDao;
import com.student.db.DBConnect;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServerException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao dao = new StudentDao(DBConnect.getConnection());
		dao.deleteStudent(id);
		resp.sendRedirect("list");
	}
}
