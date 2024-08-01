<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USEINFO 테이블에 저장된 행을 삭제하고 [user_list.jsp] 문서를 요청할 수
있는 URL 주소로 응답하는 JSP 문서 --%>   
<%-- => 관리자만 요청 가능한 JSP 문서 --%>
<%-- => 현재 로그인 사용자(관리자)가 자신의 회원정보를 삭제한 경우 [user_logout_action.jsp] 문서를
요청할 수 있는 URL 주소로 응답 처리 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	
	//비로그인 사용자이거나 관리자가 아닌 경우에 대한 응답 처리 - 비정상적인 요청
	if(loginUserinfo == null || loginUserinfo.getAuth() != 9) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	if(request.getParameter("userid") == null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoModelOneDAO.getDAO().deleteUserinfo(userid);
	
	if(loginUserinfo.getUserid().equals(userid)) {
		response.sendRedirect("user_logout_action.jsp");
	} else {
		response.sendRedirect("user_list.jsp");
	}
%>  