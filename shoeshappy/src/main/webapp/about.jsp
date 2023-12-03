<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>About</title>
</head>
<body>
<%@ include file="components/header.jsp" %>
<main>
<section class="d-flex w-100 h-100 justify-content-center align-items-center">
<div class="d-flex justify-content-center align-items-center">
	<div class="d-flex flex-column p-5">
		<h1>Sobre</h1>
		<p>Esse projeto foi desenvolvido como avaliação da disciplina de desenvolvimento de sistemas!</p>
	</div>
	<div class="d-flex flex-column p-5">
		<h1>Grupo</h1>
		<div class="row row-cols-md-2 g-2 h-100">
			<div class="col"  style="width: 34%;">
				<div class="card" style="width: 18rem;">
				<div class="card-header">
				    Marcelo Augusto
				  </div>
				  <img src="images/fotoperfil.jpg" class="card-img-top" alt="..." style="height: 380px;">
				  <div class="card-body">
				    <p class="card-text">Atrevessando barreiras com o pão de queijo!</p>
				  </div>
				</div>
			</div>
			<div class="col" style="width: 34%; ">
				<div class="card" style="width: 18rem; ">
				<div class="card-header">
				    Henrich Silva
				  </div>
				  <img src="images/henrichzoadao.jpeg" class="card-img-top" alt="..." style="height: 380px;">
				  <div class="card-body">
				    <p class="card-text">Herdeiro.</p>
				  </div>
				</div>
			</div>
			<div class="col" style="width: 34%;">
				<div class="card" style="width: 18rem;">
				<div class="card-header">
				    Rafael
				  </div>
				  <img src="images/rafael.PNG" class="card-img-top" alt="...">
				  <div class="card-body">
				    <p class="card-text">Herdeiro.</p>
				  </div>
				</div>
			</div>
			<div class="col" style="width: 34%;">
				<div class="card" style="width: 18rem;">
				<div class="card-header">
				    Samuel
				  </div>
				  <img src="images/samuel.png" class="card-img-top" alt="...">
				  <div class="card-body">
				    <p class="card-text">Curitibano.</p>
				  </div>
				</div>
			</div>
			<div class="col" style="width: 34%;">
				<div class="card" style="width: 18rem;">
				<div class="card-header">
				    Gabriel Indio
				  </div>
				  <img src="images/gabriel.png" class="card-img-top" alt="...">
				  <div class="card-body">
				    <p class="card-text">Patriota.</p>
				  </div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>
</main>
<%@ include file="components/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>