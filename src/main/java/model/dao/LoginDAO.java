package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class LoginDAO {
	
	/**
	 * ユーザIDとパスワードを使ってログイン処理をします
	 *
	 * @param bean ユーザIDとパスワードが格納されているUserBeanインスタンス
	 * @return user_name もしくは null
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public String login(UserBean bean) throws ClassNotFoundException, SQLException {
		
		/* 変数の初期化 */
		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?"; // SQL文
		
		/* データベースへの接続の取得、PreparedStatementの取得 */
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt
				= con.prepareStatement(sql)) {
			
			/* プレースホルダに値をセット */
			pstmt.setString(1, bean.getUserId());
			pstmt.setString(2, bean.getPassword());
			
			/* SQLステートメントの実行 */
			ResultSet res = pstmt.executeQuery();
			
			/* nextメソッドの結果によってreturnが分岐するif文 */
			if (res.next()) { // trueの場合…
				
				return res.getString("user_name"); // 戻り値としてuser_nameを返す
				
			} else { // falseの場合…
				
				return null; // 戻り値としてnullを返す
			}
		}
	}
}
