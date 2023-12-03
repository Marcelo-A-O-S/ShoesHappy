package server.controllers;

import java.io.IOException;


import bussines.repositories.UsuarioRepository;
import bussines.services.UsuarioServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class mainController
 */
@WebServlet( urlPatterns = {
		"/",
		"/home",
		"/about"
		}, name = "mainController")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public mainController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		switch(path) {
			case "/":
			case "/home":
				Home(request, response);
				break;
			case "/about":
				About(request, response);
				break;
			default:
				NotFound(request, response);
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
		
		RequestDispatcher renderizar = request.getRequestDispatcher("index.jsp");
		renderizar.forward(request,response);
	}
	protected void About(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("about.jsp").forward(request, response);
	}
	protected void NotFound(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/errors/notfound.jsp").forward(request, response);
	}
	

}
