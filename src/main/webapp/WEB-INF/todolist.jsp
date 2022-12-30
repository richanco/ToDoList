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
<title>ToDo</title>
</head>
<h1>ToDoList</h1>
<body>
    <hr>
	<form action="ToDoListServlet" method="post">
		Add List <input type="text" name="todo">
		       <input type="submit" value="add">
    </form>
    <hr>
    <table border="1">
       <tr>
          <th>ID</th>
          <th>TASK</th>
          <th>STATUS</th>
       </tr>
        <% for (int i = 0; i < list.size(); i++) { %>
        
       <tr>
          <td><%=list.get(i).getId()%></td>
          <td><a href="ToDoEditServlet?id=<%= list.get(i).getId()%>" ><%=list.get(i).getName()%></a></td>
          <td><%=list.get(i).getProgress()%><br></td>
       </tr>
       
       <%   } %>
    </table>
 </body>
</html>