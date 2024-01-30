package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.TaskRegisterDAO;
import model.entity.CategoryBean;
import model.entity.RegisterBean;
import model.entity.StatusBean;
import model.entity.UserRegisterBean;

@WebServlet("/taskRegisterServlet")
public class TaskRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TaskRegisterServlet() {
        super();
    }

	// タスク登録画面表示はGETだからこのdoGetメソッドが呼び出される
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストオブジェクトのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");

		List<CategoryBean> categoryList = null;
		List<UserRegisterBean> userList = null;
		List<StatusBean> statusList = null;

		// daoオブジェクトを生成
		TaskRegisterDAO dao = new TaskRegisterDAO();

		try {
			categoryList = dao.getCategory();
			userList = dao.getUser();
			statusList = dao.getStatus();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストスコープへの属性の設定 Listをタスク登録画面に送る
		HttpSession session = request.getSession();
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("userList", userList);
		session.setAttribute("statusList", statusList);

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("taskRegister.jsp");
		rd.forward(request, response);
	}
	
	// タスク登録実行
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");
		
		RegisterBean register = new RegisterBean();
		
		// リクエストパラメータの取得
		register.setTaskName(request.getParameter("taskName"));
		register.setCategoryId(Integer.parseInt(request.getParameter("categoryId")));
		register.setLimitDate(Date.valueOf(request.getParameter("limitDate")).toLocalDate());
		register.setUserId(request.getParameter("userId"));
		register.setStatusCode(request.getParameter("statusCode"));
		register.setMemo(request.getParameter("memo"));
		
		// daoオブジェクトを生成
		TaskRegisterDAO dao = new TaskRegisterDAO();

		try {
			dao.register(register);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("taskRegisterResult.jsp");
		rd.forward(request, response);
	}

}
