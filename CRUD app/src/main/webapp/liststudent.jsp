<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="header.jsp"></jsp:include>
<body>
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Roll No</th>
      <th scope="col">Name</th>
      <th scope="col">STD</th>
      <th scope="col">Marks</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  
  <tbody>
  <% ArrayList<StudentBean> list = (ArrayList<StudentBean>)request.getAttribute("list");
  	for(int i=0;i<list.size();i++)
  	{
  		
  	StudentBean sbean = list.get(i);
  %>
    <tr>
      <th scope="row"><%=sbean.getRno() %></th>
      <td><%=sbean.getName() %></td>
      <td><%=sbean.getStd() %></td>
      <td><%=sbean.getMarks() %></td>
      <td><a href="EditStudentServlet?rno=<%=sbean.getRno() %>" class="btn btn-primary">EDIT</a> | <a href="DeleteStudentServlet?rno=<%=sbean.getRno() %>" class="btn btn-danger">DELETE</a></td>
    </tr>
    <%} %>
      </tbody>
</table>
<a href="LogoutStudentServlet" class="btn btn-danger">LogOut</a>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>