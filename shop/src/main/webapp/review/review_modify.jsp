<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 게시글의 변경값을 입력받기 위한 JSP 문서 --%>
<%-- => 글번호를 전달받아 REVIEW 테이블에 저장된 하나의 행을 검색하여 입력태그의 초기값으로 출력 --%>
<%-- => 로그인 사용자가 게시글 작성자이거나 관리자인 경우에만 JSP 문서 요청 가능 --%>
<%-- => [글변경] 태그를 클릭한 경우 [/review/review_modify_action.jsp] 문서를 요청하여 페이지 이동 - 입력값 전달 --%>

<%@include file="/security/login_check.jspf" %>
<%
	//비정상적으로 JSP 문서를 요청한 경우에 대한 응답 처리
	if(request.getParameter("reviewNum") == null) {//전달값이 없는 경우
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;
	}

	//전달값을 반환받아 저장
	int reviewNum=Integer.parseInt(request.getParameter("reviewNum"));
	String pageNum=request.getParameter("pageNum");
	String pageSize=request.getParameter("pageSize");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	
	//글번호를 전달받아 REVIEW 테이블에 저장된 하나의 행을 검색하여 ReviewDTO 객체로 반환하는
	//ReviewDAO 클래스의 메소드 호출
	ReviewDTO review=ReviewDAO.getDAO().selectReviewByNum(reviewNum);
	
	//비정상적으로 JSP 문서를 요청한 경우에 대한 응답 처리
	if(review == null) {//검색된 게시글이 없는 경우 
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;
	}
	
	//비정상적으로 JSP 문서를 요청한 경우에 대한 응답 처리
	// => 로그인 사용자가 게시글 작성자가 아니고 관리자도 아닌 경우
	if(loginMember.getMemberNum() != review.getReviewMemberNum() && loginMember.getMemberAuth() != 9) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;
	}
%>
<style type="text/css">
table {
	margin: 0 auto;
}

th {
	width: 100px;
}

td {
	text-align: left;
}
</style>
<h1>게시글 변경</h1>

<%-- 파일을 입력받아 요청 웹프로그램에서 전달하기 위해서는 enctype 속성값을 반드시 
[multipart/form-data]로 설정 --%>
<form action="<%=request.getContextPath()%>/index.jsp?workgroup=review&work=review_modify_action"
	method="post" enctype="multipart/form-data" id="reviewForm">
	<input type="hidden" name="reviewNum" value="<%=reviewNum%>">	
	<input type="hidden" name="pageNum" value="<%=pageNum%>">	
	<input type="hidden" name="pageSize" value="<%=pageSize%>">	
	<input type="hidden" name="search" value="<%=search%>">	
	<input type="hidden" name="keyword" value="<%=keyword%>">	
	<table>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="reviewSubject" 
					id="reviewSubject" size="40" value="<%=review.getReviewSubject()%>">
				<input type="checkbox" name="reviewStatus" 
					value="2" <% if(review.getReviewStatus() == 2) { %>checked<% } %>>비밀글
			</td>	
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="7" cols="60" name="reviewContent" 
					id="reviewContent"><%=review.getReviewContent() %></textarea>
			</td>
		</tr>
		<tr>
			<th>이미지파일</th>
			<td>
				<input type="file" name="reviewImage"><br>
				<% if(review.getReviewImage() != null) { %>
					<div style="color: red;">이미지를 변경할 경우에만 파일을 입력해 주세요.</div>
					<img src="<%=request.getContextPath()%>/review_images/<%=review.getReviewImage()%>" width="200">
				<% } %>
		
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<button type="submit">글변경</button>
				<button type="reset" id="resetBtn">다시쓰기</button>
			</th>
		</tr>
	</table>
</form>
<div id="message" style="color: red;"></div>

<script type="text/javascript">
$("#reviewSubject").focus();

$("#reviewForm").submit(function() {
	if($("#reviewSubject").val() == "") {
		$("#message").text("제목을 입력해 주세요.");
		$("#reviewSubject").focus();
		return false;
	}
	
	if($("#reviewContent").val() == "") {
		$("#message").text("내용을 입력해 주세요.");
		$("#reviewContent").focus();
		return false;
	}
});

$("#resetBtn").click(function() {
	$("#reviewSubject").focus();
	$("#message").text("");
});
</script>