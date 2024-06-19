<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body style="background-color: #e8eddf;">


	<div class="container"
		style="background-color: #F1DABF; border: 2px solid black;">

		<div class="title" style="padding: 10px;">
			<h1>Add book to your Shelf</h1>
		</div>

		<div class="form" style="padding: 10px;">

			<form action="productInsert">
				<label for="id">ID:</label> <br> <input type="number"
					placeholder="Book unique id" name="id"> <br>
				<br> <label for="name">Book Title:</label> <br> <input
					type="text" placeholder="Book title" name="name"> <br>
				<br> <label for="text">Book Author:</label> <br> <input
					type="text" name="author" placeholder="Book author">
				<br>
				<br> <label for="category">Book Category</label> <br>
				<select name="category" id="category">
					<option value="Adventure">Adventure</option>
					<option value="Comedy">Comedy</option>
					<option value="Fantasy">Fantasy</option>
					<option value="History">History</option>
					<option value="Horror">Horror</option>
					<option value="Motivational">Motivational</option>
					<option value="Self-Help">Self-Help</option>
					<option value="Fiction">Fiction</option>
					<option value="Thriller">Thriller</option>
				</select> <br>
				<br> <label for="price">Price:</label> <br> <input
					type="number" name="price" placeholder="Book price &#8377">
				<br>
				<br>
				<button type="submit">Register</button>

			</form>
		</div>
		</div>
</body>
</html>