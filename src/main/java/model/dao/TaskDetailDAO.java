package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.TaskBean;

public class TaskDetailDAO {
	
	/**
	 * タスクIDに該当するタスクを検索して、検索結果のタスク情報を返します
	 *
	 * @param taskId 検索条件に入れるタスクID
	 * @return タスク情報
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public TaskBean selectTaskDetail(int taskId) throws ClassNotFoundException, SQLException {
		
		/* TaskBeanクラスのインスタンスの生成 */
		TaskBean bean = new TaskBean();
		
		/* 変数の初期化 */
		String sql = "SELECT t.task_id, t.task_name, c.category_name, t.limit_date, u.user_name, s.status_name, t.memo, t.create_datetime, t.update_datetime\n"
				+ " FROM\n"
				+ " (t_task t JOIN m_category c ON t.category_id = c.category_id)\n"
				+ " JOIN m_user u ON t.user_id = u.user_id\n"
				+ " JOIN m_status s ON t.status_code = s.status_code\n"
				+ " WHERE t.task_id = ?"; // SQL文
		
		/* データベースへの接続の取得、PreparedStatementの取得 */
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt
				= con.prepareStatement(sql)) {
			
			/* プレースホルダに値をセット */
			pstmt.setInt(1, taskId);
			
			/* SQLステートメントの実行 */
			ResultSet res = pstmt.executeQuery();
			
			/* 検索結果があればインスタンスに値を格納するif文 */
			if (res.next()) {
				
				/* 検索結果の値をそれぞれインスタンスに格納 */
				bean.setTaskId(res.getInt("task_id"));
				bean.setTaskName(res.getString("task_name"));
				bean.setCategoryName(res.getString("category_name"));
				if (res.getDate("limit_date") != null) bean.setLimitDate(res.getDate("limit_date").toLocalDate()); // limit_dateの値がnullでなければインスタンスに格納
				bean.setUserName(res.getString("user_name"));
				bean.setStatusName(res.getString("status_name"));
				bean.setMemo(res.getString("memo"));
				bean.setCreateDatetime(res.getTimestamp("create_datetime").toLocalDateTime());
				bean.setUpdateDatetime(res.getTimestamp("update_datetime").toLocalDateTime());
			}
		}
		
		return bean;
	}
}
