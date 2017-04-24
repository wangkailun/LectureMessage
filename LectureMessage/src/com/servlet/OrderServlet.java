package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.db.OrderDB;

public class OrderServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request , response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDB order = new OrderDB();
		String username = request.getParameter("username");
		String temp = request.getParameter("id");
		String action = request.getParameter("action");
		int lecture_id = Integer.parseInt(temp);
		
		System.out.println(username);
		System.out.println(action);
		System.out.println(lecture_id);
		
		boolean result;
		
		if(action.equals("order"))
		{
			result = order.setOrderStatic(lecture_id, username);
			if(result == true)
			{
				response.sendRedirect(request.getContextPath()+"/queryLecture.jsp");
			}
		}
		if(action.equals("del"))
		{
			result = order.deleteOrderStatic(lecture_id, username);
			if(result == true)
			{
				response.sendRedirect(request.getContextPath()+"/queryLecture.jsp");
			}
		}	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
