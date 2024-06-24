<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes</title>
<%@include file="all_js_jsp.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
	<div class="container">
		
		<br>

		<h1>All Notes:</h1>

		<div class="row">
			<div class="col-12">

				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from Note");
				List<Note> list = q.list();
				for (Note note : list) {
				%>
				<div class="card mt-3">
					<img class="card-img-top px-4 mt-3 " style="max-width:100px" src="img/pencil.png" alt="Card image cap"> 
					<div class="card-body px-4">
						<h5 class="card-title "><%=note.getTitle()%></h5>
						<p class="card-text"><%=note.getContent()%></p>
						<a href="DeletNoteServlet?note_id=<%= note.getId()  %>" class="btn btn-danger">Delete</a>
						<a href="edit_notes.jsp?note_id=<%= note.getId() %>" class="btn btn-primary">Edit</a>
					</div>
				</div>
				<%
				}
				s.close();
				%>
			</div>
		</div>


	</div>
</body>
</html>