package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		StudentDao dao = new StudentDao();
		
		int rowseffected = dao.deleteStudent(rno);
		
		if(rowseffected>0)
		{
			request.getRequestDispatcher("ListStudentServlet").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("insertstudent.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
