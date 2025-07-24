package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		
		String calc = request.getParameter("operator");
		
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' /><title>POST DATA</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>계산결과</h1><hr />");
		switch(calc) {
			case "+" -> out.println("<div>" + number1 + calc + number2 + "=" + (number1 + number2));
			case "-" -> out.println("<div>" + number1 + calc + number2 + "=" + (number1 - number2));
			case "*" -> out.println("<div>" + number1 + calc + number2 + "=" + (number1 * number2));
			case "/" -> out.println("<div>" + number1 + calc + number2 + "=" + ((double)number1 / (double)number2));
		}
		out.println("<br /><a href='#' onclick='history.back()'>이전 페이지</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
