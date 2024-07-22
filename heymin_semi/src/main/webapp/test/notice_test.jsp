<%@page import="xyz.itwill.dao.NoticeDAO"%>
<%@page import="xyz.itwill.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- REVIEW 테이블에 행(게시글)을 500개 삽입하는 JSP 문서 - 테스트 프로그램 --%>
<%
	NoticeDTO notice=new NoticeDTO();
	for(int i=1;i<=50;i++) {
		int nextNum=NoticeDAO.getDAO().selectNoticeNextNum();
		notice.setNoticeNum(nextNum);
		notice.setNoticeTitle("테스트-"+i);
		notice.setNoticeImage("이미지경로-"+i);
		notice.setNoticeClientNum(1);
		notice.setNoticeStatus(0);
		
		NoticeDAO.getDAO().insertNotice(notice);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>50개의 테스트 게시글을 삽입 하였습니다.</h1>
</body>
</html>