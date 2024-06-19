package com.personal.book_management_webapp.controller;

import java.io.IOException;

import com.personal.book_management_webapp.dao.BookDao;
import com.personal.book_management_webapp.dto.BookDto;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


@WebServlet(value="/productInsert")
public class BookInsertController extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		BookDao dao=new BookDao();
		int id= Integer.parseInt(req.getParameter("id"));
		String name= req.getParameter("name");
		String author= req.getParameter("author");
		String category=req.getParameter("category");
		float price= Float.parseFloat(req.getParameter("price"));
		
		
		
		BookDto book=new BookDto(id,name,author,category,price);
		dao.saveIntoBookDao(book);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
		dispatcher.include(req, res);
		
		
		
	}
}