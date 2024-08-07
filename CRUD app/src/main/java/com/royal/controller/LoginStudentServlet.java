package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		boolean flag = false;
		
		HttpSession session = null;
		
		if(uname!=null && (uname.trim().length()>0))
		{
			request.setAttribute("uname",uname);
		}
		else
		{
			flag = true;
			request.setAttribute("errUname", "<p>Enter Valid UserName<p>");
		}
		
		
		if(pass!=null && (pass.trim().length()>0))
		{
			request.setAttribute("pass",pass);
		}
		else
		{
			flag = true;
			request.setAttribute("errPass", "<p>Enter Valid Password<p>");
		}
		
		if(flag)
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);;
		}
		else
		{
			if(uname.equals("akki") && pass.equals("1234"))
			{
				System.out.println("LoginServlet ----- welcome");
				session = request.getSession(true);
				request.getRequestDispatcher("insertstudent.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
