package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ToDo;

public class ToDoListDAO {
	
	Connection con = null;
	 public List<ToDo> findAll(){  ///voidは後で修正
		try {
            Class.forName("org.mariadb.jdbc.Driver");

			//データベース接続
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/todolist", "root", "chanrihomaromaro14");
			Statement st = con.createStatement();
			String sql = "select * from task;";
			ResultSet result = st.executeQuery(sql);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int progress = result.getInt("progress");
				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("progress:" + progress);
			}
			
			
			if (con != null) {
				con.close();
			}
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("接続に失敗しました。");
		}
        List<ToDo> toDoList = new ArrayList<>();
        return toDoList;  ////////////修正する
	}

}
