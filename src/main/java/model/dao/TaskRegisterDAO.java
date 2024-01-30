package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;
import model.entity.RegisterBean;
import model.entity.StatusBean;
import model.entity.UserRegisterBean;

public class TaskRegisterDAO {

	// カテゴリIDとカテゴリ名をDBからListに入れて返すメソッド
	public List<CategoryBean> getCategory() throws SQLException, ClassNotFoundException {

		// Listを作成
		List<CategoryBean> categoryList = new ArrayList<>();

		String sql = "SELECT * FROM m_category";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				int categoryId = res.getInt("category_id");
				String categoryName = res.getString("category_name");

				// categoryオブジェクトを生成
				CategoryBean category = new CategoryBean();

				category.setCategoryId(categoryId);
				category.setCategoryName(categoryName);

				categoryList.add(category);
			}
		}
		return categoryList;
	}

	// ユーザIDとユーザ名をDBからListに入れて返すメソッド
	public List<UserRegisterBean> getUser() throws SQLException, ClassNotFoundException {

		// Listを作成
		List<UserRegisterBean> userList = new ArrayList<>();

		String sql = "SELECT * FROM m_user";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				String userId = res.getString("user_id");
				String userName = res.getString("user_name");

				UserRegisterBean user = new UserRegisterBean();

				user.setUserId(userId);
				user.setUserName(userName);

				userList.add(user);
			}
		}
		return userList;
	}

	// ステータスコードとステータス名をDBからListに入れて返すメソッド
	public List<StatusBean> getStatus() throws SQLException, ClassNotFoundException {

		// Listを作成
		List<StatusBean> statusList = new ArrayList<>();

		String sql = "SELECT * FROM m_status";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				String statusCode = res.getString("status_code");
				String statusName = res.getString("status_name");

				StatusBean status = new StatusBean();

				status.setStatusCode(statusCode);
				status.setStatusName(statusName);

				statusList.add(status);
			}
		}
		return statusList;
	}
	
	// 登録実行のメソッド
	public int register(RegisterBean register) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO t_task (task_name, category_id, limit_date, user_id, status_code, memo) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, register.getTaskName());
			pstmt.setInt(2, register.getCategoryId());
			pstmt.setDate(3, Date.valueOf(register.getLimitDate()));
			pstmt.setString(4, register.getUserId());
			pstmt.setString(5, register.getStatusCode());
			pstmt.setString(6, register.getMemo());
			
			// 処理されたレコード件数をregisterメソッドの呼び出し元に返す
			int count = pstmt.executeUpdate();
			return count;
		}
	}
	
}
