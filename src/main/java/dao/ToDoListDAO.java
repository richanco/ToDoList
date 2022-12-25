package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ToDo;

public class ToDoListDAO {

	Connection con = null;

	public List<ToDo> findAll() { ///voidは後で修正
		List<ToDo> toDoList = new ArrayList<>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			//データベース接続
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/todolist", "root", "chanrihomaromaro14");
			Statement st = con.createStatement();
			String sql = "select * from task;";
			ResultSet result = st.executeQuery(sql);
			//データベースのデータ取得
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int progress = result.getInt("progress");
				ToDo todo = new ToDo(id, name, progress);
				toDoList.add(todo);
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("接続に失敗しました。");
		}
		return toDoList;
	}

	public boolean add(String todo) {
		try {
			//データベース接続
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/todolist", "root", "chanrihomaromaro14");
			
			//INSERT文の準備
			String sql = "INSERT INTO task(name) VALUES (?) ;";
			PreparedStatement pStmt = con.prepareStatement(sql);
			
			//INSERT文中の「？」に使用する値を設定しSQLを設定
			pStmt.setString(1, todo);
		    
			//INSERT文を実行
		    int result = pStmt.executeUpdate();
		    if(result !=1) {
		    	return false;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("接続に失敗しました");
			return false;
		}
		return true;
		
	}

}
