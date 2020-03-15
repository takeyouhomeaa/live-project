package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static String ip = "47.93.213.196";
	static int port = 3306;
	static String database = "test";
	static String encoding = "UTF-8";
	static String loginName = "test1";
	static String password = "xY36iZcTehxPrt23";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?" +
				"serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false", ip, port, database);
		return DriverManager.getConnection(url, loginName, password);
	}

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null){
				rs.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (stmt != null){
				stmt.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (conn != null){
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
	}
}