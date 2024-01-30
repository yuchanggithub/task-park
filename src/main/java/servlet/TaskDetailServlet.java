package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskDetailDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDetailServlet
 */
@WebServlet("/taskDetailServlet")
public class TaskDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* TaskBeanクラスのインスタンスの生成 */
		TaskBean bean = new TaskBean();
		
		/* データベースアクセスオブジェクトの生成 */
		TaskDetailDAO dao = new TaskDetailDAO();
		
		/* リクエストエンコーディング方式を指定 */
		request.setCharacterEncoding("UTF-8");
		
		/* データベースアクセスオブジェクトの利用 */
		try {
			
			/* selectTaskDetailメソッドを呼び出して戻り値をインスタンスに格納 */
			bean = dao.selectTaskDetail(Integer.parseInt(request.getParameter("taskId")));
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		/* セッションの利用を開始 */
		HttpSession session = request.getSession();
		
		/* リクエストスコープへの属性の設定 */
		session.setAttribute("taskBean", bean);
		
		/* リクエストの転送 */
		RequestDispatcher rd = request.getRequestDispatcher("taskDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
