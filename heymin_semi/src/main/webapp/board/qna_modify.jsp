<%@page import="xyz.itwill.dao.QnaDAO"%>
<%@page import="xyz.itwill.dto.QnaDTO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="xyz.itwill.dto.ClientDTO"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/security/login_check.jspf"%>
<%
	if(request.getParameter("qnaNum")==null) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;
	}
	
	int qnaNum=Integer.parseInt(request.getParameter("qnaNum"));
	String pageNum=request.getParameter("pageNum");
	
	QnaDTO qna=QnaDAO.getDAO().selectQnaByNum(qnaNum);
	
	if(qna == null) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;		
	}
	
	if(loginClient.getClientNum() != qna.getQnaClientNum() && loginClient.getClientStatus() != 9 ){
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?workgroup=error&work=error_400");
		return;		
	}

%>

<meta charset="UTF-8">
<link rel="stylesheet" href="css/qna_write_style.css">
<link rel="stylesheet" href="css/common.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


<title>상품문의 수정</title>

<div id="container">
	<div id="contents">
        <div class="sub_content">
            <div class="content">
                <div class="board_zone_sec">
                    <div class="board_zone_tit">
                    <% if(loginClient.getClientStatus() == 9 ) { %>
                        <h2>상품문의 답변</h2>
                    <% } else { %>
                        <h2>상품문의 수정</h2>                    
                    <% } %>
                    </div>
                    
                    <form action="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=qna_modify_action"
									method="post" enctype="multipart/form-data" id="qnaForm">
						<input type="hidden" name="qnaNum" value="<%=qnaNum%>">
						<input type="hidden" name="pageNum" value="<%=pageNum %>">
                    	<div class="board_zone_cont">
							<div class="board_zone_write">
								<div class="board_write_box">								
									<table class="board_write_table">
										<colgroup>
											<col style="width: 15%;">
											<col style="width: 85%;">
										</colgroup>
										<tbody>
											<tr>
												<th scope="row">말머리</th>
												<td>
													<div class="category_select">
														<select class="tune" id="category" name="qnaSubject" style="width: 127px;">
															<option value="문의내용" <%= "문의내용".equals(qna.getQnaSubject()) ? "selected" : "" %>>문의내용</option>
															<option value="상품" <%= "상품".equals(qna.getQnaSubject()) ? "selected" : "" %>>상품</option>
															<option value="배송" <%= "배송".equals(qna.getQnaSubject()) ? "selected" : "" %>>배송</option>
															<option value="반품/환불" <%= "반품/환불".equals(qna.getQnaSubject()) ? "selected" : "" %>>반품/환불</option>
															<option value="교환/변경" <%= "교환/변경".equals(qna.getQnaSubject()) ? "selected" : "" %>>교환/변경</option>
															<option value="기타" <%= "기타".equals(qna.getQnaSubject()) ? "selected" : "" %>>기타</option>
														</select>
														<input type="checkbox" name="qnaStatus" value="2"<% if(qna.getQnaStatus()==2){ %>checked<% } %>>비밀글
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row" id="qna_writer">작성자</th>
												<td>
													<input type="text" name="qnaWriter"  value="<%=qna.getQnaWriter()%>">
												</td>
											</tr>
											<tr>
												<th scope="row">상품 선택</th>
												<td>
													<input type="text" name="qnaProductNum" value="<%=qna.getQnaProductNum()%>">
												</td>
											</tr>
											
											<!-- 
											<tr>
												<th scope="row">상품 선택</th>
												<td>
													<div class="board_goods_select">
														<span>선택된 상품이 없습니다.</span>
														<a href="#" title="찾아보기" class="btn_goods_select">상품 선택</a>
													</div>
												</td>
											</tr>
											 -->
											 
											 
											<tr>
												<th scope="row">제목</th>
												<td>
													<input type="text" name="qnaTitle" value="<%=qna.getQnaTitle()%>">
												</td>
											</tr>
											<tr>
												<th scope="row">본문</th>
												<td class="write_editor">
													<textarea class="content_editor" name="qnaContent" cols="30" rows="10" >
													<%=qna.getQnaContent()%>
													</textarea>
												</td>
											</tr>
											<% if(loginClient.getClientStatus() == 9 ) { %>
											<tr>
												<th scope="row">답변</th>
												<td>
													<textarea class="content_editor" name="qnaReply" cols="30" rows="5"></textarea>
												</td>
											</tr>
											<% } %>
											<tr>
												<th scope="row">첨부파일</th>
												<td id="uploadBox">
													<div class="file_upload_sec">
														<div class="btn_upload_box">
															<input type="file" name="qnaImage" class="btn_upload">
															<% if(qna.getQnaImage() != null) { %>
																<div style="color: red;">이미지를 변경할 경우에만 파일을 입력해 주세요.</div><br>
																<img src="<%=request.getContextPath()%>/qna_images/<%=qna.getQnaImage()%>">
															<% } %>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="btn_center_box">
								<button type="button" class="btn_before" id="listBtn">이전</button>
								<button type="submit" class="btn_write_ok">수정</button>
							</div>
                    	</div>
                    </form>
                </div>
            </div>
        </div>
	</div>
</div>
<script type="text/javascript">
$("#qna_writer").focus();

$("#listBtn").click(function(){
	location.href="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=qna_detail"
			+"&qnaNum=<%=qna.getQnaNum()%>&pageNum=<%=pageNum%>";
});

</script>

















