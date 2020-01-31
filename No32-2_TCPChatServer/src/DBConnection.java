import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
	private Connection con;
	private Statement st;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/no33_tcpchat?characterEncoding=UTF-8&serverTimezone=UTC", "root", "@@");
			st = con.createStatement();
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류 : " + e.getMessage());
		}
	}
	
	public void logChat(String ID, String chat) {
		try {
			String SQL = "insert into chat (id, chat) values ('" + ID + "', '" + chat + "')";
			st.executeUpdate(SQL);
		}catch(Exception e) {
			System.out.println("데이터베이스 오류 : " + e.getMessage());
		}
	}
}
