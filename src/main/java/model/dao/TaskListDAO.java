package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

public class TaskListDAO {
	
	public List<TaskBean> selectTaskAll() throws ClassNotFoundException, SQLException {
		
		/* TaskBean型のリストの生成 */
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		
		/* 変数の初期化 */
		String sql = "SELECT t.task_id, t.task_name, c.category_name, t.limit_date, u.user_name, s.status_name, t.memo, t.create_datetime, t.update_datetime\n"
				+ " FROM\n"
				+ " (t_task t JOIN m_category c ON t.category_id = c.category_id)\n"
				+ " JOIN m_user u ON t.user_id = u.user_id\n"
				+ " JOIN m_status s ON t.status_code = s.status_code\n"
				+ " ORDER BY t.task_id;"; // SQL文
		
		/* データベースへの接続の取得、PreparedStatementの取得 */
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			/* SQLステートメントの実行 */
			ResultSet res = pstmt.executeQuery();
			
			/* 検索結果がなくなるまで繰り返すWhile文 */
			while (res.next()) {
				
				/* TaskBean型のインスタンスを生成 */
				TaskBean bean = new TaskBean();
				
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
				
				/* リストにインスタンスを追加 */
				taskList.add(bean);
			}
		}
		
		return taskList;
	}
}
