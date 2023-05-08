import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
   	//従業員一覧を表示させる		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "jdbc:mysql://localhost:3306/attendanceManagement";
		String user = "root";
		String dbpass = "password";
		
		//ログイン情報確認
		HttpSession session = request.getSession();
		String loginFlg = (String)session.getAttribute("loginFlg");
		Integer loginId = (Integer)session.getAttribute("loginId");

		if(loginFlg == null || loginFlg==""){
			String redirectUrl = "/attendanceManagement/login";
			response.sendRedirect(redirectUrl);
		}else{
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
	
			String sql = "SELECT * FROM users";
			try(
				Connection connection = DriverManager.getConnection(url, user, dbpass);
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery()){
				
					List<Integer> idList = new ArrayList<>();
					// ArrayList<HashMap<Integer,String>> nameMap = new ArrayList<HashMap<Integer,String>>();
					// ArrayList<HashMap<Integer,String>> mailMap = new ArrayList<HashMap<Integer,String>>();
					HashMap<Integer,String> nameColumns = new HashMap<Integer,String>();
					HashMap<Integer,String> mailColumns = new HashMap<Integer,String>();
	
					while(results.next()){
						int id = results.getInt("id");
						String name = results.getString("name");
						String mail = results.getString("mail");
						
						//データの投入
						idList.add(id);
						nameColumns.put(id, name);
						mailColumns.put(id, mail);
	
						// nameMap.add(nameColumns);
						// mailMap.add(mailColumns);
					}
					request.setAttribute("idList",idList);
					request.setAttribute("nameMap",nameColumns);
					request.setAttribute("mailMap",mailColumns);
					request.setAttribute("loginId",loginId);
			}catch (Exception e) {
				request.setAttribute("message","Exception:"+e.getMessage());
			}
	
	
			String view = "./WEB-INF/views/list.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);

		}

	}
}