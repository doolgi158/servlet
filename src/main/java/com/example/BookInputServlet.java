package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookInput")
public class BookInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String intitle = request.getParameter("title");
		String inwriter = request.getParameter("writer");
		String inpublicer = request.getParameter("publicer");

		BookDTO book = new BookDTO(intitle, inwriter, inpublicer);
				
		request.setAttribute("book", book);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("bookOutput");
		dispatch.forward(request, response);
	}
}
