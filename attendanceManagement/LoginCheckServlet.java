import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		//バリデーション
		List<String> caveatList = new ArrayList<>();
		
		if(mail == null || mail == ""){
			caveatList.add("メールアドレスが入力されていません。");
		}

		if(password == null || password==""){
			caveatList.add("パスワードが入力されていません。");
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
			e.printStackTrace();
		}

		String sql = "SELECT * FROM users WHERE mail = ?";
		try(
			Connection connection = DriverManager.getConnection(url, user, dbpass);
			PreparedStatement statement = connection.prepareStatement(sql)){
				
				statement.setString(1, mail);
				ResultSet results = statement.executeQuery();

				
				Integer id = null;
				String getMail = null;
				String getPass = null;
				while(results.next()){
					id = results.getInt("id");
					getMail = results.getString("mail");
					getPass = results.getString("password");
				}
				if(password.equals(getPass)){
					HttpSession session = request.getSession();
					
					session.setAttribute("loginFlg", "loginFlg");
					session.setAttribute("loginId", id);
				}else{
					caveatFlg = true;
					caveatList.add("ログインできませんでした。");
				}

			


				connection.close();

		}catch (Exception e) {
			request.setAttribute("message","Exception:"+e.getMessage());
		}

		if(caveatFlg){
			request.setAttribute("caveatList",caveatList);
			view = "./WEB-INF/views/error.jsp";	
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}else{
			String redirectUrl = "/attendanceManagement/list";

			response.sendRedirect(redirectUrl);
		}

	}
}