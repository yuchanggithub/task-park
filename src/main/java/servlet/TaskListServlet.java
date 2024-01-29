package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskListDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/taskListServlet")
public class TaskListServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* TaskBeanクラスのリストを生成 */
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		
		/* データベースアクセスオブジェクトの生成 */
		TaskListDAO dao = new TaskListDAO();
		
		/* リクエストエンコーディング方式を指定 */
		request.setCharacterEncoding("UTF-8");
		
		/* データベースアクセスオブジェクトの利用 */
		try {
			
			/* selectTaskAllメソッドを呼び出して戻り値をインスタンスに格納 */
			taskList = dao.selectTaskAll();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		/* リクエストスコープへの属性の設定 */
		request.setAttribute("taskList", taskList);
		
		/* リクエストの転送 */
		RequestDispatcher rd = request.getRequestDispatcher("taskList.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
