<%@page import="xyz.itwill.dto.ClientDTO"%>
<%@page import="xyz.itwill.dto.QnaDTO"%>
<%@page import="xyz.itwill.dao.QnaDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="xyz.itwill.dto.NoticeDTO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//게시글 조회기능에 필요한 전달값(조회대상과 조회단어)을 반환받아 저장
	String uploadDate=request.getParameter("uploadDate");//조회대상
	if(uploadDate == null) {//전달값이 없는 경우 - 조회기능을 사용하지 않은 경우
		uploadDate="";
	}
	
	//페이징 처리에 필요한 전달값(페이지번호와 게시글갯수)을 반환받아 저장
	int pageNum=1;//페이지번호 - 전달값이 없는 경우 사용할 기본값 저장
	if(request.getParameter("pageNum") != null) {//전달값이 있는 경우
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	int pageSize=16;//게시글갯수 - 전달값이 없는 경우 사용할 기본값 저장
	
	//QNA 테이블에 저장된 모든 행을 반환하는 QnaDAO 클래스의 메소드 호출
	int totalQna=QnaDAO.getDAO().selectTotalQna();//게시글의 총 갯수
	
	//페이지의 총갯수를 계산하여 저장
	int totalPage=(int)Math.ceil((double)totalQna/pageSize);
	
	//전달받은 페이지번호가 비상적인 경우 첫번째 페이지를 요청할 수 있는 기본값 저장
	if(pageNum <= 0 || pageNum > totalPage) {
		pageNum=1;
	}
	
	//페이지번호에 대한 게시글의 시작 행번호를 계산하여 저장
	//ex) 1Page : 1, 2Page : 11, 3Page : 21, 4Page : 31, ...
	int startRow=(pageNum-1)*pageSize+1;
	
	//페이지번호에 대한 게시글의 종료 행번호를 계산하여 저장
	//ex) 1Page : 16, 2Page : 32, 3Page : 48, 4Page : 64, ...
	int endRow=pageNum*pageSize;	
	
	//마지막 페이지의 게시글의 종료 행번호가 게시글의 총갯수보다 많은 경우 종료 행변호 변경
	if(endRow > totalQna) {
		endRow=totalQna;
	}
	
	//페이징 관련 정보(시작행번호, 종료행번호)와 게시글 조회기능 관련 정보(조회대상과 조회단어)를
	//전달받아 NOTICE 테이블에 저장된 행에서 조회정보가 포함된 행을 페이징 처리로 검색하여
	//List 객체를 반환하는 NoticeDAO 클래스의 메소드 호출
	//List<NoticeDTO> noticeList=NoticeDAO.getDAO().selectNoticeList(startRow, endRow, uploadDate);
	//int qnaClientNum=0;
	//int qnaClientNum=Integer.parseInt(request.getParameter("clientNum"));
	
    String qnaClientNumStr = request.getParameter("qnaClientNum");
    int qnaClientNum = 0;

    if (qnaClientNumStr != null && !qnaClientNumStr.isEmpty()) {
        try {
            qnaClientNum = Integer.parseInt(qnaClientNumStr); // 파라미터를 정수로 변환
        } catch (NumberFormatException e) {
            out.println("[에러] qnaClientNum 변환 오류: " + e.getMessage());
            // 기본값이나 예외 처리 로직 추가 가능
        }
    }
	QnaDTO qna=QnaDAO.getDAO().selectQnaByClientNum(qnaClientNum);
	
	//페이징 관련 정보(시작행번호, 종료행번호)를 전달받아 QNA 테이블에 저장된 행을
	//검색하여 List 객체를 반환하는 QnaDAO 클래스의 메소드 호출
	List<QnaDTO> qnaList=QnaDAO.getDAO().selectQnaList(startRow, endRow);
	
	//세션에 저장된 권한 관련 정보가 저장된 속성값을 객체로 반환받아 저장
	// => 로그인 사용자에게만 글쓰기 권한 제공
	// => 게시글이 비밀글인 경우 로그인 사용자가 게시글 작성자이거나 관리자인 경우에만 권한 제공
	ClientDTO loginClient=(ClientDTO)session.getAttribute("loginClient");
	
	//서버의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 SimpleDateFormat 객체에 저장된
	//패턴의 문자열로 변환하여 저장
	// => 게시글의 작성날짜와 비교하여 게시글 작성날짜를 다르게 출력되도록 응답 처리
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	//게시글에 출력될 일련번호 시작값을 계산하여 저장
	// => 게시글의 총갯수가 91개인 경우 => 1Page : 91, 2Page : 81, 3Page : 71, ...\
	//int displayNum=totalQna-(pageNum-1)*pageSize;
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/qna_list_style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<title>상품문의</title>
</head>
<body>
<div class="sub_content">
            <div class="content">
                <div class="board_zone_sec">
                    <div class="board_zone_tit">
                        <h2>상품문의</h2>
                    </div>
                    <div class="btn_right_box">
                    	<button type="button" class="btn_mine" id="mineBtn">내가 쓴 글 보기</button>
                        <button type="button" class="btn_write" id="writeBtn" >
                            <strong class="write_text" >1:1 문의하기</strong>
                        </button>
                    </div>
                    <div class="board_zone_con">
                        <div class="board_zone_list">
                            <div class="board_list_qa">
                                <table class="board_list_table" style="width: 100%;">
                                    <thead>
                                        <tr>
                                            <th class="board_date">문의날짜</th>
                                            <th class="board_category">카테고리</th>
                                            <th class="board_title">제목</th>
                                            <th class="board_writer">작성자</th>
                                            <th class="board_state">문의상태</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% if(totalQna == 0) { %>
                                    	<tr style="height: 10px;">
                                    		<td class="board_table_nosearch" colspan="6">검색된 게시글이 없습니다.</td>
                                    	</tr>
                                    <% } else { 
                                    	int displayNum=totalQna-((pageNum-1)*pageSize);%>
	                                    <% for(QnaDTO  qnaItem : qnaList) { 
	                                    	if(qnaItem.getQnaStatus() != 0) { %>
		                                        <tr style="height: 10px;">
		                                            <td class="board_date">
		                                            <%if(currentDate.equals(qnaItem.getQnaDate().substring(0, 10))) { %>
		                                            	<%=qnaItem.getQnaDate().substring(11) %>
		                                            <% } else { %>
		                                            	<%=qnaItem.getQnaDate().substring(0, 10) %>
		                                            <% } %>
		                                            </td>
		                                            
		                                            <td class="board_category"><%=qnaItem.getQnaSubject() %></td>
		                                            
		                                            <td class="board_tit">
		                                            	<%
		                                            		String url=request.getContextPath()+"/index.jsp?workgroup=board&work=qna_detail"
		                                            		 +"&qnaNum="+qnaItem.getQnaNum()+"&pageNum="+pageNum;
		                                            	%>
		                                            	<a href="<%=url %>"><%=qnaItem.getQnaTitle() %></a>
		                                            </td>
		                                            
		                                            <td class="board_writer">
														<%
									                        String clientName = qnaItem.getClientName();
									                        if (clientName != null && clientName.length() > 1) {
									                            String maskedName = clientName.substring(0, 1) + "*" + clientName.substring(2);%>
									                            <%=maskedName %>
									                       <% } else { %>
									                             <%=clientName %>
									                     <% } %>
													</td>
		                                            <td class="board_state">
			                                            <% if(qnaItem.getQnaReply() != null) { %>
			                                            답변완료
			                                            <% } else { %>
			                                            답변대기
			                                            <% } %>
		                                            </td>
		                                        </tr>                                        
		                                       <% 
		                                       		displayNum--;
		                                       		} 
		                                       %>
	                                       <% } %>
                                       <% } %>
                                    </tbody>
                                </table>
                            </div>
                            <%
                            	int blockSize=5;
                            	
                            	int startPage=(pageNum-1)/blockSize*blockSize+1;
                            	
                            	int endPage=startPage+blockSize-1;
                            	
                            	if(endPage > totalPage) {
                            		endPage=totalPage;
                            	}
                            %>
                            <%
                            	String myUrl=request.getContextPath()+"/index.jsp?workgroup=board&work=qna_list";
                            %>
                            
                            <div class="pagination" id="page_list">
                            <% if(totalPage > 5) { %>
                            	<% if(startPage > blockSize) { %>
									<a href="<%=myUrl %>&pageNum=<%=startPage-blockSize %>">◁</a>
								<% } else { %>
									◁
								<% } %>
							<% } %>
								<% for(int i = startPage; i <= endPage; i++) { %>
									<a href="#">1</a>
							   <a href="#">▷</a>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript">
	
	$("#writeBtn").click(function() {
		location.href="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=qna_write";
	});
	</script>
</body>
</html>