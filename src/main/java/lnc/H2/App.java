package lnc.H2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * H2
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		// 加载数据库驱动
		Class.forName("org.h2.Driver");

		// 创建数据库连接
		Connection conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/test", "sa", null);
		// 创建数据库操作类
		Statement stmt = conn.createStatement();

		// 执行删表语句
		stmt.execute("DROP TABLE IF EXISTS T_USER");

		// 执行建表语句
		stmt.execute("CREATE TABLE T_USER(ID INT PRIMARY KEY, NAME VARCHAR2(255));");

		// 执行插入语句
		stmt.executeUpdate("INSERT INTO T_USER VALUES(1, 'Hello')");
		stmt.executeUpdate("INSERT INTO T_USER VALUES(2, 'World')");
		stmt.executeUpdate("INSERT INTO T_USER VALUES(3, 'H2')");
		stmt.executeUpdate("INSERT INTO T_USER VALUES(4, 'Git')");

		// 执行查询语句
		ResultSet rs = stmt.executeQuery("SELECT * FROM T_USER");
		while (rs.next()) {
			System.out.println(rs.getString("NAME"));
		}

		// 关闭数据库连接
		stmt.close();
		conn.close();
	}
}
