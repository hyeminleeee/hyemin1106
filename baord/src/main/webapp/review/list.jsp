<%@page import="xyz.itwill.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardDTO> boardList=(List<BoardDTO>)request.getAttribute("boardList");
%>
<!DOCTYPE html>
<style type="text/css">
#review_list {
	width: 1000px;
	margin: 0 auto;
	text-align: center;
}

#review_title {
	font-size: 1.2em;
	font-weight: bold;
}

table {
	margin: 5px auto;
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border: 1px solid black;
	background: black;
	color: white;
}

td {
	border: 1px solid black;
	text-align: center;	
}

.subject {
	text-align: left;
	padding: 5px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#review_list a:hover {
	text-decoration: none; 
	color: blue;
	font-weight: bold;
}

.subject_hidden {
	background: black;
	color: white;
	font-size: 14px;
	border: 1px solid black;
	border-radius: 4px;
}

.write_button {
	text-align: right;
}

</style>
<h1></h1>
<div id="review_list">
	<%-- 검색된 게시글의 총갯수 출력 --%>
	<div id="review_title">제품후기</div>
	<div class="write_button">
		<button>글쓰기</button>
	</div>
	<%-- 검색된 게시글 목록 출력 --%>
	<table>
		<tr>
			<th width="100">글번호</th>
			<th width="500">제목</th>
			<th width="100">작성자</th>
			<th width="100">조회수</th>
			<th width="200">작성일</th>
		</tr>
		<% for(BoardDTO board : boardList) { %>
		<tr>
			<%-- 게시글의 일련번호 출력 --%>
			<td>1</td>

			<%-- 게시글 제목 출력 --%>
			<td class="subject"><%= %></td>

			<td>회원이름</td>
			
			<%-- 게시글 조횟수 출력 --%>
			<td>조회수</td>
			
			<%-- 게시글 작성일 출력 --%>
			<td>작성일</td>	

		</tr>
		<% } %>
	</table>

</div>

<script type="text/javascript">

</script>