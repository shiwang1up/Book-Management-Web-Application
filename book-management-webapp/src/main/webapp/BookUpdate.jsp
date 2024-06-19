<%@page import="com.personal.book_management_webapp.dto.BookDto"%>
<%@page import="com.personal.book_management_webapp.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body style="background-color: #e8eddf;">

	<%
	BookDao dao = new BookDao();
	%>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
<%-- 	<% BookDto book=new BookDto(99,"a","a","a",123); --%>
 	<% BookDto book= dao.displayBookByIdDao(id);%>

	<div class="container"
		style="background-color: #F1DABF; border: 2px solid black;">

		<div class="title" style="padding: 10px;">
			<h1>Update your book</h1>
		</div>

		<div class="form" style="padding: 10px;">

			<form action="bookUpdate">
				<label for="id">ID:</label> <br> <input type="number"
					value="<%= book.getId()%>"name="id" disabled="disabled"> <br> <br>
				<label for="name">Book Title:</label> <br> <input type="text"
					value="<%= book.getTitle()%>" name="name"> <br> <br>
				<label for="text">Book Author:</label> <br> <input type="text"
					name="author" value="<%= book.getAuthor()%>"> <br> <br>
				<label for="category">Select Book Category</label> <br> <select
					name="category" id="category">
					<option value="Adventure">Adventure</option>
					<option value="Comedy">Comedy</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Motivational">Motivational</option>
					<option value="Self-Help">Self-Help</option>
					<option value="Fiction">Fiction</option>
					<option value="Thriller">Thriller</option>
				</select> <br> <br> <label for="price">Price:</label> <br> <input
					type="number" name="price" value="<%= book.getPrice()%>">
				<br> <br>
				<button type="submit">Update</button>

			</form>
		</div>
	</div>
	

</body>
</html>