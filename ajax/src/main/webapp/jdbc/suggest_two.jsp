<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dao.SuggestDAO"%>
<%@page import="xyz.itwill.dto.SuggestDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 검색어를 전달받아 SUGGEST 테이블에 저장된 행에서 검색어가 포함된 모든 행을 검색하여 XML로 
응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return;
	}
	
	//POST 방식으로 요청하여 전달된 값을 읽기 위한 문자형태 변경
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 저장
	String keyword=request.getParameter("keyword");

	//검색어(String 객체)를 전달받아 SUGGEST 테이블에 저장된 행에서 검색어가 포함된 모든
	//행을 검색하여 List 객체로 반환하는 SuggestDAO 클래스의 메소드 호출
	List<SuggestDTO> suggestList=SuggestDAO.getDAO().selectSuggestList(keyword);
%>
<result>
	<% if(!suggestList.isEmpty()) {//검색된 행이 있는 경우 %>
	<code>success</code>
	<%-- List 객체를 자바스크립트의 Array 객체로 변환하여 응답 처리하고 List 객체의 요소값
	(SuggestDTO 객체)를 자바스크립트의 Object 객체로 변환하여 응답 처리 --%>
	<data><![CDATA[
		[
		<% for(int i=0;i<suggestList.size();i++) { %>
			<% if(i > 0) {%>,<% } %>
			{"word":"<%=suggestList.get(i).getWord()%>", "url":"<%=suggestList.get(i).getUrl()%>"}
		<% } %>
		]	
	]]></data>
	<% } else {//검색된 행이 있는 경우 %>
	<code>empty</code>
	<% } %>
</result>