package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EMP 테이블에 저장된 모든 행(사원정보)의 사원번호,사원이름,급여를 급여로 내림차순 정렬하여
//검색하여 사원정보를 출력하는 JDBC 프로그램 작성
public class SelectEmpApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			String url="oracle:jdbc:thin:@localhost:1521:xe";
			String username="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, username, password);
			
			stmt=con.createStatement();
			
			String sql="select empno,ename,job,mgr,hirdate,sal,comm,deptno from emp order by sal desc";
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				do {
					int empno=rs.getInt("empno");
					String ename=rs.getString("ename");
					String job=rs.getString("job");
					int mgr=rs.getInt("mgr");
					String hirdate=rs.getString("hirdate");
					int sal=rs.getInt("sal");
					int comm=rs.getInt("comm");
					int deptno=rs.getInt("deptno");
					
					System.out.println("사원번호 : "+empno);
					System.out.println("사원이름 : "+ename);
					System.out.println("부서이름 : "+job);
					System.out.println("관리자 : "+mgr);
					System.out.println("입사일 : "+hirdate.substring(0,10));
					System.out.println("급여 : "+sal);
					System.out.println("상여금 : "+comm);
					System.out.println("부서번호 : "+deptno);
					System.out.println("=========================================");
				} while(rs.next());
			} else {
				System.out.println("검색 결과가 없습니다.");
				}
			} catch (ClassNotFoundException e) {
				System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
			} catch (SQLException e) {
				System.out.println("[에러]DBMS 에러 : "+e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
