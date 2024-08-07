package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session!=null)
		{
			String name = request.getParameter("name");
			String std = request.getParameter("std");
			String marks = request.getParameter("marks");
			
			boolean flag = false;
			StudentBean sbean = new StudentBean();
		
			
			if(name != null & (name.trim().length()>0))
			{
				sbean.setName(name);
				request.setAttribute("name",name);
			}
			else
			{
				flag = true;
				request.setAttribute("errName", "<p>Please Enter Valid Name<p>");
			}
			
			if(std != null & (std.trim().length()>0))
			{
				sbean.setStd(std);
				request.setAttribute("std",std);
			}
			else
			{
				flag = true;
				request.setAttribute("errStd", "<p>Please Enter Valid STD<p>");
			}
			
			if(marks != null & (marks.trim().length()>0))
			{
				sbean.setMarks(Integer.parseInt(marks));
				request.setAttribute("marks",marks);
			}
			else
			{
				flag = true;
				request.setAttribute("errMarks", "<p>Please Enter Valid Marks<p>");
			}
			
			RequestDispatcher rd = null;
			if(flag)
			{
				rd = request.getRequestDispatcher("insertstudent.jsp");
			}
			else
			{
				StudentDao dao = new StudentDao();
				int rowseffected = dao.insertStudent(sbean);
					
				if(rowseffected > 0)
				{
					rd = request.getRequestDispatcher("ListStudentServlet");
				}
				else
				{
					rd = request.getRequestDispatcher("insertstudent.jsp");
				}
			}
					
			rd.forward(request, response);

		}
		else
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
