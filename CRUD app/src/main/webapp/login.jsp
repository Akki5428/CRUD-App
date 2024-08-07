<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<style>
	body{
		height:100vh;
		display:flex;
		justify-content: center;
		align-items: center;
	}
	
</style>

<body>
	
	<form action="LoginStudentServlet">
	
	<center>
	
  <div class="form-group">
    <label for="">Username</label>
    <input type="text" class="form-control" id="exampleInputEmail1"  placeholder="Username" name="uname" value="${uname}">
  	<span>${errUname}</span>
  </div>
  <div class="form-group">
    <label for="">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pass" value="${pass}">
  	<span>${errPass}</span>
  </div>
  </br>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>