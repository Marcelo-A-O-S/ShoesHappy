<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registro</title>
</head>
<body>
<%@ include file="../components/header.jsp" %>
<section class="d-flex w-100 vh-100 p-3 flex-column">
<div>
<c:if test="${cliente == null }">
	<h1>Registrar cliente</h1>
</c:if>
<c:if test="${cliente != null }">
	<h1>Atualizar cliente</h1>
</c:if>
<fieldset>
	<legend>Formulário</legend>
	<c:if test="${cliente != null }">
		<form class="row g-3 p-3" action="atualizarCliente" method="post">
	</c:if>
	<c:if test="${cliente == null }">
		<form class="row g-3 p-3" action="registrarCliente" method="post">
	</c:if>
	<form class="row g-3 p-3" action="registrarCliente" method="post">
	<c:if test="${cliente != null }">
	<div class="col-md-4">
	    <label for="nome" class="form-label">Matricula</label>
	    <input type="text" class="form-control" id="matricula" name="matricula" value="<c:out value="${cliente.matricula}"/>" placeholder="Nome do cliente" required>
	  </div>
	</c:if>
	  
	  <div class="col-12">
	    <label for="nome" class="form-label">Nome</label>
	    <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${cliente.nome}"/>" placeholder="Nome do cliente" required>
	  </div>
	  <div class="col-md-6">
	    <label for="email" class="form-label">Email</label>
	    <input type="email" class="form-control" id="email" name="email" value="<c:out value="${cliente.email}"/>" placeholder="" required >
	  </div>
	  
	  <div class="col-md-6">
	    <label for="modalidade" class="form-label">Modalidade</label>
	    <select  name="modalidade" class="form-select">
	      <option value="Pessoa Fisica"  ${cliente.modalidade.equals("Pessoa Fisica")? 'selected' : ''}>Pessoa Fisica</option>
	      <option value="Pessoa Juridica" ${cliente.modalidade.equals("Pessoa Juridica") ? 'selected' : ''}>Pessoa Juridica</option>
	    </select>
	  </div>
	<div class="col-12">
	    <label for="cidade" class="form-label">Cidade</label>
	    <input type="text" class="form-control" id="cidade" name="cidade" value="<c:out value="${cliente.cidade}"/>" placeholder="Nome da cidade" required>
	  </div>
	  <div class="col-md-6">
	    <label for="bairro" class="form-label">Bairro</label>
	    <input type="text" class="form-control" id="bairro" name="bairro" value="<c:out value="${cliente.bairro}"/>" required>
	  </div>
	  <div class="col-md-6">
	    <label for="estado" class="form-label">Estado</label>
	    <input type="text" class="form-control" id="estado" name="estado" value="<c:out value="${cliente.estado}"/>" required>
	  </div>
	  <div class="col-md-6">
	    <label for="rua" class="form-label">Rua</label>
	    <input type="text" class="form-control" id="rua" name="rua" value="<c:out value="${cliente.rua}"/>" required>
	  </div>
	  <div class="col-md-6">
	    <label for="numero" class="form-label">Numero</label>
	    <input type="text" class="form-control" id="numero" name="numero" value="<c:out value="${cliente.numero}"/>" required/>
	  </div>
	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">Registrar</button>
	  </div>
     </form>
</fieldset>
</div>
</section>
<%@ include file="../components/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>