package test.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Simple2JDBCDAO {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/smart?characterEndoing=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "SELECT * FROM exam";

//		1. 드라이버 로드 (Class.forName())
		Class.forName("com.mysql.cj.jdbc.Driver");
//		2. DB연결(DriverManager.getConnection())
		Connection conn = DriverManager.getConnection(url, user, password);
//		3. SQL문작성(Statement, PrepareStatement)
		Statement stmt = conn.createStatement();
//		4. SQL문실행(executeQuery(), executeUpdate())
		ResultSet rs = stmt.executeQuery(sql); // Query 실행
//		5. Select문 만 ResultSet 객체를 반환한다..
//		   나머진 int를 반환한다.
		while (rs.next()) {
			System.out.printf("varcharTest:%s,", rs.getString("varchartest"));
			System.out.printf("varcharTest:%s,", rs.getString("chartest"));
			System.out.printf("varcharTest:%s,", rs.getString("inttest"));
			System.out.printf("varcharTest:%s,", rs.getString("datetest"));
			System.out.printf("varcharTest:%s %n", rs.getString("datetimetest"));
		}
//		6. 닫기(close())
		rs.close();
		stmt.close();
		conn.close();

	}

}
