package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookOutput")
public class BookOutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");		
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		BookDTO book = (BookDTO)request.getAttribute("book");
		
		out.println("<!DOCTYPE html><html><head><meta charset='UTF-8' />");
		out.println("<title>책정보</title>");
		out.println("<link rel='icon' href='data:,'></head>");
		out.println("<body>");
		out.println("<h3>입력한 책정보</h3><hr />");
		out.println("<div>책제목: " + book.getTitle() + "</div>");
		out.println("<div>책저자: " + book.getWriter() + "</div>");
		out.println("<div>출판사: " + book.getPublicer() + "</div>");
		out.println("</body></html>");
		
		out.close();
	}
}
