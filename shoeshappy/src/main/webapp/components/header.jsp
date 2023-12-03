<jsp:useBean id="usuario"  class="server.BeansViews.UsuarioBean" type="server.BeansViews.UsuarioBean" scope="session"/>
<link rel="stylesheet" href=""/>
<%if(usuario.usuario == null){%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="main">ShoesHappy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="${request.getContextPath()}/shoeshappy/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about.jsp">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${request.getContextPath()}/shoeshappy/login">Login</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%}else{%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">ShoesHappy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="clientes">Gerenciamento de Clientes</a>
        </li>
      </ul>
      <div class="d-flex">
      <ul class="navbar-nav align-items-center">
        <li class="nav-item">
      		<%= usuario.GetUsuario() %>
      	</li>
      	<li class="nav-item">
          <a class="nav-link" href="logout">Log out</a>
        </li>
      </ul>
      	
      </div>
    </div>
  </div>
</nav>
<%}%>