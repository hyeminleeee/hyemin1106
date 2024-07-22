package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.itwill.dto.ClientDTO;

public class ClientDAO extends JdbcDAO {
	private static ClientDAO _dao;

	private ClientDAO() {
		// TODO Auto-generated constructor stub
	}

	static {
		_dao = new ClientDAO();
	}

	public static ClientDAO getDAO() {
		return _dao;
	}

	// 회원정보(ClientDTO 객체)를 전달받아 CLIENT 테이블의 행으로 삽입하고 삽입행의 갯수(int)를 반환하는 메소드
	public int insertClient(ClientDTO client) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();

			String sql = "insert into client values(client_seq.nextval,?,?,?,?,?,?,?,?,sysdate,null,null,1)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientId());
			pstmt.setString(2, client.getClientPasswd());
			pstmt.setString(3, client.getClientName());
			pstmt.setString(4, client.getClientEmail());
			pstmt.setString(5, client.getClientMobile());
			pstmt.setString(6, client.getClientZipcode());
			pstmt.setString(7, client.getClientAddress1());
			pstmt.setString(8, client.getClientAddress2());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertClient() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 아이디(String 객체)를 전달받아 CLIENT 테이블에 저장된 하나의 행을 검색하여 검색된
	// 회원정보(ClientDTO)를 반환하는 메소드
	public ClientDTO selectClientById(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientDTO client = null;
		try {
			con = getConnection();

			String sql = "select client_num,client_id,client_passwd,client_name,client_email"
					+ ",client_mobile,client_zipcode,client_address1,client_address2"
					+ ",client_register_date,client_update_date,client_last_login,client_status"
					+ " from client where client_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				client = new ClientDTO();
				client.setClientNum(rs.getInt("client_num"));
				client.setClientId(rs.getString("client_id"));
				client.setClientPasswd(rs.getString("client_passwd"));
				client.setClientName(rs.getString("client_name"));
				client.setClientEmail(rs.getString("client_email"));
				client.setClientMobile(rs.getString("client_mobile"));
				client.setClientZipcode(rs.getString("client_zipcode"));
				client.setClientAddress1(rs.getString("client_address1"));
				client.setClientAddress2(rs.getString("client_address2"));
				client.setClientRegisterDate(rs.getString("client_register_date"));
				client.setClientUpdateDate(rs.getString("client_update_date"));
				client.setClientLastLogin(rs.getString("client_last_login"));
				client.setClientStatus(rs.getInt("client_status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectClientById() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return client;
	}
	
	// 이메일(String 객체)를 전달받아 CLIENT 테이블에 저장된 하나의 행을 검색하여 검색된
	// 회원정보(ClientDTO)를 반환하는 메소드
	public ClientDTO selectClientByEmail(String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientDTO client = null;
		try {
			con = getConnection();
			
			String sql = "select client_num,client_id,client_passwd,client_name,client_email"
					+ ",client_mobile,client_zipcode,client_address1,client_address2"
					+ ",client_register_date,client_update_date,client_last_login,client_status"
					+ " from client where client_email=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				client = new ClientDTO();
				client.setClientNum(rs.getInt("client_num"));
				client.setClientId(rs.getString("client_id"));
				client.setClientPasswd(rs.getString("client_passwd"));
				client.setClientName(rs.getString("client_name"));
				client.setClientEmail(rs.getString("client_email"));
				client.setClientMobile(rs.getString("client_mobile"));
				client.setClientZipcode(rs.getString("client_zipcode"));
				client.setClientAddress1(rs.getString("client_address1"));
				client.setClientAddress2(rs.getString("client_address2"));
				client.setClientRegisterDate(rs.getString("client_register_date"));
				client.setClientUpdateDate(rs.getString("client_update_date"));
				client.setClientLastLogin(rs.getString("client_last_login"));
				client.setClientStatus(rs.getInt("client_status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectClientById() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return client;
	}

	// 회원번로(int)를 전달받아 CLIENT 테이블에 저장된 하나의 행을 검색하여 검색된 회원정보
	// (ClientDTO)를 반환하는 메소드
	public ClientDTO selectClientByNum(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientDTO client = null;
		try {
			con = getConnection();

			String sql = "select client_num,client_id,client_passwd,client_name,client_email"
					+ ",client_mobile,client_zipcode,client_address1,client_address2"
					+ ",client_register_date,client_update_date,client_last_login,client_status"
					+ " from client where client_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				client = new ClientDTO();
				client.setClientNum(rs.getInt("client_num"));
				client.setClientId(rs.getString("client_id"));
				client.setClientPasswd(rs.getString("client_passwd"));
				client.setClientName(rs.getString("client_name"));
				client.setClientEmail(rs.getString("client_email"));
				client.setClientMobile(rs.getString("client_mobile"));
				client.setClientZipcode(rs.getString("client_zipcode"));
				client.setClientAddress1(rs.getString("client_address1"));
				client.setClientAddress2(rs.getString("client_address2"));
				client.setClientRegisterDate(rs.getString("client_register_date"));
				client.setClientUpdateDate(rs.getString("client_update_date"));
				client.setClientLastLogin(rs.getString("client_last_login"));
				client.setClientStatus(rs.getInt("client_status"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectClientByNum() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return client;
	}

	// 회원번호(int)를 전달받아 CLIENT 테이블에 저장된 행에서 마지막 로그인 날짜를 현재 날짜와
	// 시간으로 변경하고 변경행의 갯수(int)를 반환하는 메소드
	public int updateLastLogin(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();

			String sql = "update client set client_last_login=sysdate where client_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateLastLogin() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 회원정보(ClientDTO 객체)를 전달받아 CLIENT 테이블에 저장된 행을 변경하고 변경행의 갯수를
	// 반환하는 메소드
	public int updateClient(ClientDTO client) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();

			String sql = "update client set client_name=?,client_email=?,client_mobile=?"
					+ ",client_zipcode=?,client_address1=?,client_address2=? where client_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientName());
			pstmt.setString(2, client.getClientEmail());
			pstmt.setString(3, client.getClientMobile());
			pstmt.setString(4, client.getClientZipcode());
			pstmt.setString(5, client.getClientAddress1());
			pstmt.setString(6, client.getClientAddress2());
			pstmt.setInt(7, client.getClientNum());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateClient() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 회원정보(ClientDTO 객체)를 전달받아 CLIENT 테이블에 저장된 행의 비빌번호를 변경하고
	// 변경행의 갯수를 반환하는 메소드
	public int updatePassword(ClientDTO client) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();

			String sql = "update client set client_passwd=? where client_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getClientPasswd());
			pstmt.setInt(2, client.getClientNum());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updatePassword() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

	// 회원정보(ClientDTO 객체)를 전달받아 CLIENT 테이블에 저장된 행의 회원권한을 변경하고
	// 변경행의 갯수를 반환하는 메소드
	public int updateAuth(ClientDTO client) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rows = 0;
		try {
			con = getConnection();

			String sql = "update client set client_status=? where client_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, client.getClientStatus());
			pstmt.setInt(2, client.getClientNum());

			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateAuth() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}

}
