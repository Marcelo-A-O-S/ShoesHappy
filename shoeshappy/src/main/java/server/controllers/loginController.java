package server.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import server.BeansViews.UsuarioBean;

import java.io.IOException;

import bussines.repositories.UsuarioRepository;
import bussines.services.UsuarioServices;
import domain.models.Usuario;

/**
 * Servlet implementation class loginController
 */
@WebServlet( urlPatterns =  "/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsuarioBean usuario = (UsuarioBean)session.getAttribute("usuario");
		if(usuario != null) {
			session.removeAttribute("usuario");
		}
		request.getRequestDispatcher("login/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("password"));
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UsuarioServices usuariosv = new UsuarioServices(new UsuarioRepository());
		Usuario usuario = usuariosv.BuscarPorEmail(email);
		if(usuario != null) {
			if(usuario.VerificarPassword(password)) {
				UsuarioBean usuarioadm = new UsuarioBean();
				UsuarioBean usuarioateste = new UsuarioBean();
				usuarioadm.SetEmail(usuario.email);
				usuarioadm.SetUsuario(usuario.usuario);
				session.setAttribute("usuario", usuarioadm);
				usuarioateste = (UsuarioBean) session.getAttribute("usuario");
				response.sendRedirect("auth/index.jsp");
			}else {
				response.sendRedirect("errors/inauthorized.jsp");
			}
		}else {
			response.sendRedirect("errors/inauthorized.jsp");
		}
	}

}
