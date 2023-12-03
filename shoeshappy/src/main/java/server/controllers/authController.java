package server.controllers;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.BeansViews.ClienteBean;
import server.BeansViews.UsuarioBean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bussines.repositories.ClienteRepository;
import bussines.repositories.EnderecoRepository;
import bussines.services.ClienteServices;
import bussines.services.EnderecoServices;
import domain.enums.Modalidade;
import domain.models.Cliente;
import domain.models.Endereco;

/**
 * Servlet implementation class authController
 */
@WebServlet(
		description = "Controller de gerenciamento de usuarios",
		urlPatterns = {
		"/auth/",
		"/auth/clientes",
		"/auth/registrarCliente", 
		"/auth/formularioCliente",
		"/auth/editar",
		"/auth/atualizarCliente",
		"/auth/logout",
		"/auth/deletar"
		})
public class authController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		UsuarioBean usuario = (UsuarioBean)session.getAttribute("usuario");
		if(usuario.usuario.equals(null)) {
			AcessDenied(request, response);
		}
		switch(path) {
			case "/auth/":
			case "/auth/home":
				Home(request, response);
				break;
			case "/auth/clientes":
				Clientes(request, response);
				break;
			case "/auth/formularioCliente":
				FormularioCliente(request, response);
				break;
			case "/auth/registrarCliente":
				RegistrarCliente(request, response);
				break;
			case "/auth/editar":
				EditarCliente(request, response);
				break;
			case "/auth/deletar":
				DeletarCliente(request, response);
				break;
			case "/auth/atualizarCliente":
				AtualizarCliente(request, response);
				break;
			case "/auth/logout":
				Logout(request, response);
				break;
			default:
				Home(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void Home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher renderizar = request.getRequestDispatcher("/auth/index.jsp");
		renderizar.forward(request, response);
	}
	protected void Clientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<ClienteBean> lista = new ArrayList<ClienteBean>();
		ClienteServices clientesv = new ClienteServices(new ClienteRepository());
		EnderecoServices enderecosv = new EnderecoServices(new EnderecoRepository());
		List<Cliente> clientes = clientesv.Listar();
		for(Cliente cliente:clientes) {
			Endereco endereco = enderecosv.BuscarPorClienteId(cliente.Id);
			ClienteBean itemlista = new ClienteBean();
			itemlista.setBairro(endereco.bairro);
			itemlista.setCidade(endereco.cidade);
			itemlista.setEstado(endereco.estado);
			itemlista.setRua(endereco.rua);
			itemlista.setNumero(endereco.numero);
			itemlista.setNome(cliente.nome);
			itemlista.setEmail(cliente.email);
			if(cliente.modalidade.equals(Modalidade.PESSOA_FISICA.toString())) {
				itemlista.setModalidade("Pessoa Fisica");
			}
			if(cliente.modalidade.equals(Modalidade.PESSOA_JURIDICA.toString())) {
				itemlista.setModalidade("Pessoa Juridica");
			}
			itemlista.setMatricula(cliente.Id);
			lista.add(itemlista);
		}
		request.setAttribute("listaClientes", lista);
		RequestDispatcher renderizar = request.getRequestDispatcher("/auth/gerenciamento-clientes.jsp");
		renderizar.forward(request, response);
	}
	protected void FormularioCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher renderizar = request.getRequestDispatcher("/auth/formulario-cliente.jsp");
		renderizar.forward(request, response);
	}
	protected void RegistrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String modalidade = request.getParameter("modalidade");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("estado");
		String rua = request.getParameter("rua");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		EnderecoServices enderecosv = new EnderecoServices(new EnderecoRepository());
		ClienteServices clientesv = new ClienteServices(new ClienteRepository());
		cliente = clientesv.BuscarPorEmail(email);
		if(cliente != null) {
			request.getRequestDispatcher("/error/dadosInvalidos.jsp");
		}
		cliente.setId(0);
		cliente.setNome(nome);
		cliente.setEmail(email);
		if(modalidade.equals("Pessoa Fisica")) {
			cliente.setModalidade(Modalidade.PESSOA_FISICA);
		}else {
			cliente.setModalidade(Modalidade.PESSOA_JURIDICA);
		}
		endereco.setId(0);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setEstado(estado);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		clientesv.Salvar(cliente);
		cliente = clientesv.BuscarPorEmail(email);
		endereco.setClienteId(cliente.Id);
		enderecosv.Salvar(endereco);
		response.sendRedirect("clientes");
	}
	protected void EditarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer matricula = Integer.parseInt(request.getParameter("matricula"));
		EnderecoServices enderecosv = new EnderecoServices(new EnderecoRepository());
		ClienteServices clientesv = new ClienteServices(new ClienteRepository());
		Cliente cliente = clientesv.BuscarPorId(matricula);
		Endereco endereco = enderecosv.BuscarPorClienteId(cliente.Id);
		ClienteBean clientevw = new ClienteBean();
		clientevw.setMatricula(cliente.Id);
		clientevw.setBairro(endereco.bairro);
		clientevw.setCidade(endereco.cidade);
		clientevw.setEstado(endereco.estado);
		clientevw.setRua(endereco.rua);
		clientevw.setNumero(endereco.numero);
		clientevw.setNome(cliente.nome);
		clientevw.setEmail(cliente.email);
		if(cliente.modalidade.equals(Modalidade.PESSOA_FISICA.toString())) {
			clientevw.setModalidade("Pessoa Fisica");
		}else {
			clientevw.setModalidade("Pessoa Juridica");
		}
		
		request.setAttribute("cliente", clientevw);
		request.getRequestDispatcher("/auth/formulario-cliente.jsp").forward(request, response);
	}
	protected void DeletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer matricula = Integer.parseInt(request.getParameter("matricula"));
		EnderecoServices enderecosv = new EnderecoServices(new EnderecoRepository());
		ClienteServices clientesv = new ClienteServices(new ClienteRepository());
		Endereco endereco = enderecosv.BuscarPorClienteId(matricula);
		enderecosv.DeletarPorId(endereco.Id);
		clientesv.DeletarPorId(matricula);
		response.sendRedirect("clientes");
	}
	protected void AtualizarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer matricula = Integer.parseInt(request.getParameter("matricula"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String modalidade = request.getParameter("modalidade");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String estado = request.getParameter("estado");
		String rua = request.getParameter("rua");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		EnderecoServices enderecosv = new EnderecoServices(new EnderecoRepository());
		ClienteServices clientesv = new ClienteServices(new ClienteRepository());
		cliente.setId(matricula);
		cliente.setNome(nome);
		cliente.setEmail(email);
		if(modalidade.equals("Pessoa Fisica")) {
			cliente.setModalidade(Modalidade.PESSOA_FISICA);
		}else {
			cliente.setModalidade(Modalidade.PESSOA_JURIDICA);
		}
		endereco = enderecosv.BuscarPorClienteId(matricula);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setEstado(estado);
		endereco.setNumero(numero);
		endereco.setRua(rua);
		clientesv.Salvar(cliente);
		enderecosv.Salvar(endereco);
		response.sendRedirect("clientes");

	}
	protected void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("usuario");
		//RequestDispatcher renderizar = request.getRequestDispatcher("/index.jsp");
		//renderizar.forward(request, response);
		response.sendRedirect(request.getContextPath() + "/");
	}
	protected void AcessDenied(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/errors/inauthorized.jsp").forward(request, response);
	}
	

}
