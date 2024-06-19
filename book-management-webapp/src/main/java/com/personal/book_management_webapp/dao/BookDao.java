package com.personal.book_management_webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.personal.book_management_webapp.connection.BookConnection;
import com.personal.book_management_webapp.dto.BookDto;

public class BookDao {
	private final String INSERT_BOOK_QUERY = "insert into book(id,name,author,category,price) values (?,?,?,?,?)";
	private final String DISPLAY_ALL_BOOK_QUERY = "select * from book";
	private final String DELETE_BOOK_BY_ID_QUERY = "delete from book where id=?";
	private final String GET_BOOK_BY_ID_QUERY = "select * from book where id=?";
	Connection connection = BookConnection.getBookConnection();
	PreparedStatement ps;

	public BookDto saveIntoBookDao(BookDto book) {

		try {
			ps = connection.prepareStatement(INSERT_BOOK_QUERY);

			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			ps.setString(4, book.getCategory());
			ps.setFloat(5, book.getPrice());

			ps.execute();
			return book;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<BookDto> displayAllBookDao() {
		try {
			ps = connection.prepareStatement(DISPLAY_ALL_BOOK_QUERY);
			ResultSet resultSet = ps.executeQuery();
			ArrayList<BookDto> bd = new ArrayList<BookDto>();
			int i = 0;
			while (resultSet.next()) {

				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String author = resultSet.getString("author");
				String category = resultSet.getString("category");
				float price = resultSet.getFloat("price");

				BookDto book = new BookDto(id, name, author, category, price);

				bd.add(book);

			}
			return bd;

		} catch (SQLException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public int deleteBookFromIdDao(int id) {
		try {
			ps = connection.prepareStatement(DELETE_BOOK_BY_ID_QUERY);
			ps.setInt(1, id);
			ps.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public BookDto displayBookByIdDao(int id) {
		BookDto book = null;
		try {
			ps = connection.prepareStatement(GET_BOOK_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int idx = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String category = rs.getString("category");
				float price = rs.getFloat("price");

				book = new BookDto(idx, name, author, category, price);

			}
			return book;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int updateBookByIdDao(BookDto book) {

		String updatQuery = "update book set name=?,author=?,category=?,price=? where id=?";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(updatQuery);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getCategory());
			ps.setFloat(4, book.getPrice());
			ps.setInt(5, book.getId());

			return ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}
}