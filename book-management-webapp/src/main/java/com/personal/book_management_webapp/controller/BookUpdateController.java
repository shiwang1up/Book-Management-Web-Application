package com.personal.book_management_webapp.controller;

import java.io.IOException;

import com.personal.book_management_webapp.dao.BookDao;
import com.personal.book_management_webapp.dto.BookDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(value="/bookUpdate")
public class BookUpdateController extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String author=req.getParameter("author");
		String category=req.getParameter("category");
		Float price=Float.parseFloat(req.getParameter("price"));
		
		BookDao dao=new BookDao();
		BookDto bookUpdated=new BookDto(id,name,author,category,price);
		dao.updateBookByIdDao(bookUpdated);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
		
	}

}
