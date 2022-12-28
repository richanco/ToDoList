package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoListDAO;
import model.ToDo;

/**
 * Servlet implementation class EditToDoList
 */
@WebServlet("/ToDoEditServlet")
public class ToDoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToDoEditServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//データベースに接続準備
		ToDoListDAO todolistDAO = new ToDoListDAO();

		//該当の値を取得
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		ToDo todo = todolistDAO.findById(id);

		//スコープにインスタンスを保存
		request.setAttribute("todo", todo);

		//JSPにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo-edit.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String statusString = request.getParameter("status");
		String idString = request.getParameter("id");
		
		// 選択した値を取得
		int status = Integer.parseInt(statusString);
		int id = Integer.parseInt(idString);

		//データベースに接続準備
		ToDoListDAO todolistDAO = new ToDoListDAO();
		todolistDAO.updateStatus(status,id);

		response.sendRedirect("/ToDoList/ToDoListServlet");
		
	}

}
