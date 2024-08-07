<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="./style.css" rel="stylesheet" >

<title>Insert Student Form</title>
</head>
<style>
	.ak{
		color : red;
	}
</style>
<body>
			<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
            <form class="mx-auto" action="InsertStudentServlet">
                <h4 class="text-center">Insert Form</h4>
                <div class="mb-3 mt-5">
                  <label for="exampleInputEmail1" class="form-label">Full Name</label>
                  <label class="ak">${errName}</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="name" value='${name}'>
                </div>
                <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">STD</label>
                   <label class="ak">${errStd}</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="std">
                </div>
                 <div class="mb-3">
                  <label for="exampleInputPassword1" class="form-label">Marks</label>
                   <label class="ak">${errMarks}</label>
                  <input type="text" class="form-control" id="exampleInputPassword1" name="marks">
                </div>
              
                <button type="submit" class="btn btn-primary mt-5">Login</button>
              </form>
        </div>
        <a href="LogoutStudentServlet" class="btn btn-danger">LogOut</a>
 <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>