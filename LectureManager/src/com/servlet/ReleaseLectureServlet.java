package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.ReleaseLectureDB;

public class ReleaseLectureServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReleaseLectureServlet() {
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

		try{
			boolean result=false;
			String theme = request.getParameter("theme");
			String author = request.getParameter("author");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String details = request.getParameter("details");
			
			time = time+":00";
			
			
			ReleaseLectureDB release = new ReleaseLectureDB();
			result = release.releaseLecture(theme, author, date , time, details);
			
			if(result == true)
			{
				response.sendRedirect(request.getContextPath()+"/releaseLectureMessage.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			}
			
		}catch(Exception e){
			System.err.println("发布servlet出现问题:"+e.getMessage());
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
