package com.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.SubjectDAO;
import com.subject.SubjectVO;

@WebServlet("/list")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SubjectDAO dao = SubjectDAO.getInstance();
		List<SubjectVO> list = dao.getAllSubjects();
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject/subjectList.jsp");
		dispatcher.forward(request, response);
	}
}
