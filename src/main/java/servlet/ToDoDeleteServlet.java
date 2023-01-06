package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoListDAO;

/**
 * Servlet implementation class ToDoDeleteServlet
 */
@WebServlet("/ToDoDeleteServlet")
public class ToDoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDoDeleteServlet() {
        super();
  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String idString = request.getParameter("id");
				
				// 選択した値を取得
				int id = Integer.parseInt(idString);

				//データベースに接続準備
				ToDoListDAO todolistDAO = new ToDoListDAO();
				todolistDAO.deleteTask(id);

				response.sendRedirect("/ToDoList/ToDoListServlet");
	}

}
