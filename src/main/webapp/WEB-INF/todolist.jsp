<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.ToDo"%>
<%
//リクエストスコープからインスタンスを取得
List<ToDo> list = (List<ToDo>) request.getAttribute("toDoList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoList</title>
</head>
<h1>ToDoList</h1>
<body>
	<form action="ToDoListServlet" method="post">
		Add List <input type="text" name="todo">
		       <input type="submit" value="add">
    </form>
	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	 <a href="ToDoEditServlet?id=<%= list.get(i).getId()%>" >
	<%=list.get(i).getId()%>
	<%=list.get(i).getName()%>
	<%=list.get(i).getProgress()%><br>
	<%
	}
	%>
	</a>
</body>
</html>