package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		System.out.println("==> HelloServlet 객체 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("==> init() 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==> doGet() 메서드 호출");
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
		out.println("<head><meta charset='UTF-8' />");
		out.println("<title>JSP 예제</title>");
		out.println("<link rel='icon' href='data:, '></head>");
		out.println("<body><h1>Hello servlet ~~!</h1></body>");
		out.println("</html>");
		
		out.close();
	}
}
