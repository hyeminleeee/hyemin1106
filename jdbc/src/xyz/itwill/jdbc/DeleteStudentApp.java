package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//STUDENT 테이블에서 학번이 [3000]인 행(학생정보)을 삭제하는 JDBC 프로그램 작성
//형식) DELETE FROM 테이블명 WHERE 조건식
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
			
			stmt=con.createStatement();
			
			String sql="delete from student where no=3000";
			int rows=stmt.executeUpdate(sql);
			
			System.out.println("[메세지]"+rows+"명의 정보가 삭제되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDrivaer 클래스를 찾지 못하였습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]DBMS 에러 = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
