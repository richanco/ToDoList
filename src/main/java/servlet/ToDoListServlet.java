package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoListDAO;
import model.ToDo;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/ToDoListServlet")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDoListServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//データベースに接続準備
		ToDoListDAO todolistDAO = new ToDoListDAO();
		//ToDoListの一覧取得
		List<ToDo> list = todolistDAO.findAll();
		
	    //スコープにインスタンスを保存
		request.setAttribute("toDoList", list);
		
		//JSPにフォワードする
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/todolist.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String todo = request.getParameter("todo");
		
		//入力値チェック
		if(todo != null && todo.length() != 0) {
			//DBに保存されたユーザー情報を取得
			ToDoListDAO todolistDAO = new ToDoListDAO();
			todolistDAO.add(todo);	
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "ToDoListが入力されていません");
		}
		
		response.sendRedirect("/ToDoList/ToDoListServlet");
	}

}
