import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.TextUI;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/UserResistServlet")
public class UserResistServlet extends HttpServlet {
   	//ログイン画面を表示させる
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パスワードの長さ指定
		int passRength = 8;

		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		//バリデーション
		
		List<String> caveatList = new ArrayList<>();
		if(name == null || name == ""){
			caveatList.add("氏名が入力されていません。");
		}
		
		if(mail == null || mail == ""){
			caveatList.add("メールアドレスが入力されていません。");
		}

		if(password == null || password==""){
			caveatList.add("パスワードが入力されていません。");
		}else if(password.length() < passRength){
			caveatList.add("パスワードは８文字以上で設定してください。");
		}

	
		String view=null;
		//警告があるか
		boolean caveatFlg = false; 
		if(caveatList.size()!=0){
			caveatFlg = true;
		}
	
		String url = "jdbc:mysql://localhost:3306/attendanceManagement";
		String user = "root";
		String dbpass = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		String sql = "INSERT into users (name,mail,password) values(?,?,?);";
		try(
			Connection connection = DriverManager.getConnection(url, user, dbpass);
			PreparedStatement statement = connection.prepareStatement(sql)){
				statement.setString(1, name);
				statement.setString(2, mail);
				statement.setString(3, password);
				statement.executeUpdate();
				connection.close();

		}catch (Exception e) {
			request.setAttribute("message","Exception:"+e.getMessage());
		}

		if(caveatFlg){
			request.setAttribute("caveatList",caveatList);
			view = "./WEB-INF/views/error.jsp";
		}else{
			view = "./WEB-INF/views/login.jsp";
		}
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);

	}
}