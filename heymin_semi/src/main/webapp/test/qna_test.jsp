<%@page import="xyz.itwill.dao.QnaDAO"%>
<%@page import="xyz.itwill.dto.QnaDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- REVIEW 테이블에 행(게시글)을 500개 삽입하는 JSP 문서 - 테스트 프로그램 --%>
<%
	QnaDTO qna=new QnaDTO();
	for(int i=1; i<=20;i++){
		int nextNum=QnaDAO.getDAO().selectQnaNextNum();
		qna.setQnaNum(nextNum);
		qna.setQnaClientNum(21);//test0001 회원번호
		qna.setQnaSubject("기타");
		qna.setQnaTitle("테스트-"+i);
		qna.setQnaContent("테스트 내용-"+i);
		qna.setQnaImage("이미지경로-"+i);
		qna.setQnaIp("***,***,***,***");
		qna.setQnaReply("답변-"+i);
		qna.setQnaProductNum(21);
		qna.setQnaStatus(1);
		qna.setQnaWriter("홍길동"+i);
		
		QnaDAO.getDAO().insertQna(qna);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>20개의 테스트 게시글을 삽입 하였습니다.</h1>
</body>
</html>