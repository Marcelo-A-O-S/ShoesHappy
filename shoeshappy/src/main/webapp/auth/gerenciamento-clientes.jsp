<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Gerenciamento</title>
</head>
<body>
<%@ include file="../components/header.jsp" %>
<section class="d-flex w-100 vh-100 p-3 flex-column">
<div>
<h1>Gerenciamento de clientes</h1>
<a href="formularioCliente" class="btn btn-primary">Registrar cliente</a>
</div>
<div>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Matricula</th>
      <th scope="col">Nome</th>
      <th scope="col">Email</th>
      <th scope="col">Modalidade</th>
      <th scope="col">Estado</th>
      <th scope="col">Cidade</th>
      <th scope="col">Bairro</th>
      <th scope="col">Rua</th>
      <th scope="col">N°</th>
      <th scope="col">Ações</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="cliente" items="${listaClientes}">
		<tr>
			<td><c:out value="${cliente.matricula}"></c:out></td>
			<td><c:out value="${cliente.nome}"></c:out></td>
			<td><c:out value="${cliente.email}"></c:out></td>
			<td><c:out value="${cliente.modalidade}"></c:out></td>
			<td><c:out value="${cliente.estado}"></c:out></td>
			<td><c:out value="${cliente.cidade}"></c:out></td>
			<td><c:out value="${cliente.bairro}"></c:out></td>
			<td><c:out value="${cliente.rua}"></c:out></td>
			<td><c:out value="${cliente.numero}"></c:out></td>
			<td>
				<a href="editar?matricula=<c:out value="${cliente.matricula}"/>" class="btn btn-primary">Editar</a>
				<a href="deletar?matricula=<c:out value="${cliente.matricula}"/>" class="btn btn-danger">Excluir</a>
			</td>
		</tr>
	</c:forEach>
  </tbody>
</table>
</div>
</section>
<%@ include file="../components/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>