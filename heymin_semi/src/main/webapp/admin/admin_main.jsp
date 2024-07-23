 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin.css">
<%--<%@include file="/camp/security/admin_check.jspf" %>--%>
<h2 class="screen_out">관리자 페이지</h2>
<div class="admin_cont admin_member">
	<div class="top_admin">
		<h3 class="tit_admin">회원관리</h3>
		<div class="wrap_btn">
			<button type="button" class="btn_admin">회원수정</button>
			<button type="button" class="btn_admin">회원삭제</button>
		</div>
	</div>
	<div class="cont_admin">
		<table class="tbl_admin">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>우편번호</th>
				<th>기본주소</th>
				<th>상세주소</th>
				<th>회원가입날짜</th>
				<th>회원변경날짜</th>
				<th>마지막 로그인날짜</th>
				<th>회원상태</th>
			</tr>
			<tr>
				<td>1</td>
				<td>abc123</td>
				<td>홍길동</td>
				<td>abc123@itwill.xyz</td>
				<td>010-1111-1111</td>
				<td>22222</td>
				<td>서울시 강남구</td>
				<td>역삼동</td>
				<td>2024-07-10</td>
				<td>2024-07-11</td>
				<td>2024-07-19</td>
				<td>1</td>
			</tr>
		</table>
	</div>
</div>

<div class="admin_cont admin_product" style="display:none">
	<div class="top_admin">
		<h3 class="tit_admin">상품관리</h3>
		<div class="wrap_btn">
			<button type="button" class="btn_admin">상품추가</button>
			<button type="button" class="btn_admin">상품수정</button>
			<button type="button" class="btn_admin">상품삭제</button>
		</div>
	</div>
	<div class="cont_admin">
		<table class="tbl_admin">
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>가격</th>
				<th>제조사</th>
				<th>유형</th>
				<th>등록일</th>
				<th>제품상태코드</th>
				<th>제품이미지</th>
				<th>상세이미지</th>
			</tr>
			<tr>
				<td>1</td>
				<td>원터치 텐트</td>
				<td>30,000원</td>
				<td>가나다</td>
				<td>텐트</td>
				<td>2024-07-20</td>
				<td>판매중</td>
				<td>00</td>
				<td>11</td>
			</tr>
		</table>
	</div>
</div>

<div class="admin_cont admin_delivery" style="display:none">
	<div class="top_admin">
		<h3 class="tit_admin">배송관리</h3>
		<div class="wrap_btn">
			<button type="button" class="btn_admin">배송정보 수정</button>
		</div>
	</div>
	<div class="cont_admin">
		<table class="tbl_admin">
			<tr>
				<th>배송번호</th>
				<th>주문번호</th>
				<th>배송 생성일</th>
				<th>배송 수정일</th>
				<th>배송 요청사항</th>
			</tr>
			<tr>
				<td>1</td>
				<td>1</td>
				<td>2024-07-10</td>
				<td>2024-07-12</td>
				<td>집 앞에 놓아주세요.</td>
			</tr>
		</table>
	</div>
</div>

