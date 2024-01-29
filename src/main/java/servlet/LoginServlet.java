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

import model.dao.LoginDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* リクエストの転送 */
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* UserBeanクラスのインスタンスを生成 */
		UserBean bean = new UserBean();
		
		/* データベースアクセスオブジェクトの生成 */
		LoginDAO dao = new LoginDAO();
		
		/* リクエストエンコーディング方式を指定 */
		request.setCharacterEncoding("UTF-8");
		
		/* リクエストパラメータの取得 */
		bean.setUserId(request.getParameter("userId"));
		bean.setPassword(request.getParameter("password"));
		
		/* データベースアクセスオブジェクトの利用 */
		try {
			
			/* loginメソッドを呼び出して戻り値をインスタンスに格納 */
			bean.setUserName(dao.login(bean));
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		/* beanのuserNameの値によって処理が分岐するif文 */
		if (bean.getUserName() != null) { // 値がnullではない場合…
			
			/* セッションの利用を開始 */
			HttpSession session = request.getSession();
			
			/* セッションスコープへの属性の設定 */
			session.setAttribute("userName", bean.getUserName());
			
			/* リクエストの転送 */
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);
			
		} else { // 値がnullの場合…
			
			/* リクエストスコープへの属性の設定 */
			request.setAttribute("userBean", bean);
			request.setAttribute("errorMessage", "ログインに失敗しました。ユーザID、もしくはパスワードが間違っています。");
			
			/* リクエストの転送 */
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
