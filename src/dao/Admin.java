package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin {

	public int login(String username, String password) throws SQLException {
		int result = -1;

		String sql = "select * from s_admin where name='" + username + "' and password='" + password + "'";

		// ��ȡ���ݿ������
		Connection con = DBUtils.getCon();

		// �����ݿ����������sql��䣩

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if (rs.next()) {
			result=1;
		}

		return result;
	}

}
