<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<%@ include file="../components/header.jsp" %>
<main>
<div class="d-flex w-100 vh-100 align-items-center justify-content-center">
	<form action="login"  class="d-flex gap-3 border p-5 " method="post">
	<figure>
		<img alt="teste" src="./images/login.jpg">
	</figure>
	<fieldset class="d-flex flex-column gap-3">
		<legend>Login</legend>
		<div class="form-floating mb-3">
		  <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
		  <label for="floatingInput">Email address</label>
		</div>
		<div class="form-floating">
		  <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
		  <label for="floatingPassword">Password</label>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</fieldset>
	</form>
	
</div>

</main>
<%@ include file="../components/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>