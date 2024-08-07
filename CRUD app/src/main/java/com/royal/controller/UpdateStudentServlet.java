package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rno = request.getParameter("rno");
		String name = request.getParameter("name");
		String std = request.getParameter("std");
		String marks = request.getParameter("marks");
		StudentBean sbean = new StudentBean();
		boolean flag = false;
		
		request.setAttribute("rno",Integer.parseInt(rno));
		
		if(name!=null && (name.trim().length()>0))
		{
			sbean.setName(name);
			request.setAttribute("name", name);
		}
		else
		{
			flag=true;
			request.setAttribute("errName", "<p>Enter Valid Name</p>");
		}
		
		
		if(std!=null && (std.trim().length()>0))
		{
			sbean.setStd(std);
			request.setAttribute("std", std);
		}
		else
		{
			flag=true;
			request.setAttribute("errStd", "<p>Enter Valid Std</p>");
		}
		
		if(marks!=null && (marks.trim().length()>0))
		{
			sbean.setMarks(Integer.parseInt(marks));
			request.setAttribute("marks", marks);
		}
		else
		{
			flag=true;
			request.setAttribute("errMarks", "<p>Enter Valid Marks</p>");
		}
		
		if(flag)
		{
			request.getRequestDispatcher("editstudent.jsp").forward(request, response);
		}
		else
		{
			StudentDao dao = new StudentDao();
			
			int rowseffected = dao.updateStudent(sbean,Integer.parseInt(rno));
			System.out.println(rowseffected);
			
			if(rowseffected>0)
			{
				request.getRequestDispatcher("ListStudentServlet").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("EditStudentServlet").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
