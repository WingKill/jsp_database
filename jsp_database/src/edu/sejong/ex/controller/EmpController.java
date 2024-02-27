package edu.sejong.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.ex.command.EmpCommand;
import edu.sejong.ex.command.EmpListCommand;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/emp/*")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() ..");
		
		actionDo(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() ..");
		
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("actionDo() ..");
		
		response.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String contextPath = request.getContextPath();
		System.out.println("contextPath : " + contextPath);
		String command = uri.substring(contextPath.length());
		System.out.println("command : " + command);
		
		EmpCommand eCommand = null;
		String viewPage = null;
		
		if(command.equals("/emp/list.do")) {
			eCommand = new EmpListCommand();
			eCommand.execute(request, response);
			viewPage = "/index2.jsp";
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}


}
