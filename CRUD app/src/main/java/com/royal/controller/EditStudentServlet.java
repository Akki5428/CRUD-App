package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		System.out.println(rno);
		
		StudentDao dao = new StudentDao();
		StudentBean sbean = dao.getStudentByRno(rno);
		
		request.setAttribute("rno", sbean.getRno());
		request.setAttribute("name", sbean.getName());
		request.setAttribute("std", sbean.getStd());
		request.setAttribute("marks", sbean.getMarks());
	
		request.getRequestDispatcher("editstudent.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
