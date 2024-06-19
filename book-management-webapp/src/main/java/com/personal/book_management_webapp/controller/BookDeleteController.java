package com.personal.book_management_webapp.controller;

import java.io.IOException;

import com.personal.book_management_webapp.dao.BookDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet(value="/bookDelete")

public class BookDeleteController extends HttpServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		BookDao dao=new BookDao();
		
		dao.deleteBookFromIdDao(id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, res);

	}
}
