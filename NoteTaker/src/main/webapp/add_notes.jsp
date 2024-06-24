<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add notes</title>
<%@include file="all_js_jsp.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container">
		
		<br>
		<h1>Please Fill Form Details: </h1>
		<br>
		<!-- this is add form -->

		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title"> Note Title</label> <input required type="text"
					name="title" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required id="content"
					placeholder="Enter your content here" name="content"
					class="form-control" style="height: 200px"></textarea>

			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Add</button>
			</div>

		</form>
	</div>
</body>
</html>