<%@page import="com.personal.book_management_webapp.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.personal.book_management_webapp.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookShelf Webapp</title>
</head>
<body style="background-color: #e8eddf;">
	<div class="container"
		style="border: 3px solid black; padding: 30px; width: 90%; background-color: #F1DABF; box-sizing: border-box;">


		<%
		BookDao dao = new BookDao();
		%>
		<%
		ArrayList<BookDto> books = dao.displayAllBookDao();
		%>

		<h1>Your Shelf</h1>

		<div class="inner-container ">
			<a href="BookEntry.jsp"><input type="button" value="Add New Book"
				style="background-color: #ffcb00;"></a> 
			<a href="index.jsp">	<input type="button"
				value="List All Books " style="background-color: #ffcb00;"></a>
		</div>



		<div class="inner-container2 ">
			<h2>List of Books</h2>

			<table border="1" style="width: 80%; background-color: #bce7fd;">
				<tr style="padding: 100px;">
					<th style="width: 5%; padding: 10px;">ID</th>
					<th style="width: 30%;">Title</th>
					<th style="width: 20%;">Author</th>
					<th style="width: 12%;">Category</th>
					<th style="width: 8%;">Price</th>
					<th colspan="2" style="width: 15%;">Actions</th>
				</tr>
				<%
				for (BookDto book : books) {
				%>
				<tr>
					<td><%=book.getId()%></td>
					<td><%=book.getTitle()%></td>
					<td><%=book.getAuthor()%></td>
					<td><%=book.getCategory()%></td>
					<td>&#8377;<%=book.getPrice()%></td>
					
					<td style="width: 7.5%; background-color: #21FA90;"><a
						href="BookUpdate.jsp?id=<%=book.getId()%>"><button
								style="width: 100%; height: 100%; background-color: #21FA90;">Update</button></a></td>
								
					<td style="width: 7.5%; background-color: #FE4A49;"><a
						href="bookDelete?id=<%=book.getId()%>"><button
								style="width: 100%; height: 100%; background-color: #FE4A49;">Delete</button></a></td>
				</tr>
				<%
				}
				%>
			</table>


		</div>


	</div>

</body>
</html>