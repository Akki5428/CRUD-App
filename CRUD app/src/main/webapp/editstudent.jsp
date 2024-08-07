<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
	body
	{
		height:100vh;
		display:flex;
		justify-content: center;
		align-items: center;
	}
	span{
	color : red;
	}
	
</style>
<body>
	
	<form action="UpdateStudentServlet">
	<center>
  <div class="form-group">
    <label for="">Roll no</label>
    <input type="text" class="form-control" id="exampleInputEmail1"  placeholder="Roll no" name="rno" value="${rno}" readonly>
  </div>
  <div class="form-group">
    <label for="">Full Name</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Full Name" name="name" value="${name}">
  	<span>${errName}</span>
  </div>
  <div class="form-group">
    <label for="">STD</label>
    <input type="text" class="form-control" id="exampleInputPassword2" placeholder="STD" name="std" value="${std}">
  	<span>${errStd}</span>
  </div>
  <div class="form-group">
    <label for="">Marks</label>   
    <input type="text" class="form-control" id="exampleInputPassword3" placeholder="Marks" name="marks" value="${marks}">
  	<span>${errMarks}</span>
  </div>
  
  </br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<a href="LogoutStudentServlet" class="btn btn-danger">LogOut</a>
</center>

</body>
</html>