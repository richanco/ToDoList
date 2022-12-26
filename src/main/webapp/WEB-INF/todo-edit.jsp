<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ToDo" %>
<% ToDo todo  = (ToDo)request.getAttribute("todo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1><%= todo.getId() %><%= todo.getName() %><%= todo.getProgress() %></h1>
</body>
</html>