<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 USERINFO 테이블에 저장된 행을 변경하고 [user_view.jsp] 문서를 요청할 수
있는 URL 주소로 응답하는 JSP 문서 - 아이디 전달 --%>     
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	request.setCharacterEncoding("utf-8");

	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	int auth=Integer.parseInt(request.getParameter("auth"));
	
	UserinfoDTO userinfo=new UserinfoDTO();
	userinfo.setUserid(userid);
	//전달값(비밀번호)이 없는 경우 - 사용자의 기존 비밀번호를 이용하야 필드값 변경
	if(password == null || password.equals("")) {
		userinfo.setPassword(UserinfoModelOneDAO.getDAO().selectUserinfo(userid).getPassword());
	} else {//전달값(비밀번호)이 있는 경우 - 전달받은 비밀번호로 필드값 변경
		userinfo.setPassword(password);
	}
	userinfo.setName(name);
	userinfo.setEmail(email);
	userinfo.setAuth(auth);
	
	UserinfoModelOneDAO.getDAO().updateUserinfo(userinfo);
	
	response.sendRedirect("user_view.jsp?userid="+userid);
%>