<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ToDo" %>
<% ToDo todo  = (ToDo)request.getAttribute("todo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDO</title>
</head>
<body>
  <h1>ToDo-Edit</h1>
  <hr>
  <form action="ToDoEditServlet" method="POST">
  ID : <input type="hidden" value="<%= todo.getId() %>" name="id"><br>
  TASK : <%= todo.getName() %><br>
  PROGRESS : <select name="status">
            <% if(0 == todo.getProgress()){ %>
            <option selected >0</option>
            <option  >1</option>
            <option  >2</option>
            <% }else if(1 == todo.getProgress()){ %>
            <option  >0</option>
            <option selected >1</option>
            <option  >2</option>
            <% } else { %>
            <option  >0</option>
            <option >1</option>
            <option selected>2</option>
            <% }  %>
            </select><br>
  <hr>
  <input type="submit" value="DELETE">
  <input type="submit" value="UPDATE"><br>
  <a href="ToDoListServlet">BACK</a>
  </form>         
</body>
</html>