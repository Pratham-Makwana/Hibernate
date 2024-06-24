<%@page import="com.entities.Note"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="all_js_jsp.jsp"%>
<title>Edit Notes</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="container">
		<br>

		<h1>Edit Notes:</h1>
		<br>

		<%
		int noteId = Integer.parseInt(request.getParameter("note_id").trim());
		Session s = FactoryProvider.getFactory().openSession();
		Note note = (Note) s.get(Note.class, noteId);
		s.close();
		%>

		<form action="UpdateNoteServlet" method="post">

			<input value="<%=note.getId()%>" name="noteId" type="hidden">
			<div class="form-group">
				<label for="title"> Note Title</label> <input required type="text"
					name="title" class="form-control" id="title"
					aria-describedby="emailHelp" placeholder="Enter title"
					value="<%=note.getTitle()%>">
			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea required id="content" style="height: 200px"
					placeholder="Enter your content here" name="content"
					class="form-control"><%=note.getContent()%></textarea>

			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save Note</button>
			</div>

		</form>
</body>
</html>