<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="xyz.itwill.dto.NoticeDTO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dao.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%
	//게시글 조회기능에 필요한 전달값(조회대상과 조회단어)을 반환받아 저장
	String uploadDate=request.getParameter("uploadDate");//조회대상
	if(uploadDate == null) {//전달값이 없는 경우 - 조회기능을 사용하지 않은 경우
		uploadDate="";
	}
	
	String keyword=request.getParameter("keyword");//조회단어
	if(keyword == null) {
		keyword="";
	}
	
	//페이징 처리에 필요한 전달값(페이지번호와 게시글갯수)을 반환받아 저장
	int pageNum=1;//페이지번호 - 전달값이 없는 경우 사용할 기본값 저장
	if(request.getParameter("pageNum") != null) {//전달값이 있는 경우
		pageNum=Integer.parseInt(request.getParameter("pageNum"));
	}
	
	int pageSize=16;//게시글갯수 - 전달값이 없는 경우 사용할 기본값 저장
	if(request.getParameter("pageSize") != null) {//전달값이 있는 경우
		pageSize=Integer.parseInt(request.getParameter("pageSize"));
	}
	
	//조회정보(조회대상과 조회단어)를 전달받아 REVIEW 테이블에 저장된 행에서 조회정보가 포함된 
	//행의 갯수를 검색하여 반환하는 NoticeDAO 클래스의 메소드 호출
	int totalNotice=NoticeDAO.getDAO().selectTotalNotice(search, keyword);//게시글의 총갯수
	
	//페이지의 총갯수를 계산하여 저장
	int totalPage=(int)Math.ceil((double)totalNotice/pageSize);
	
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
	if(endRow > totalNotice) {
		endRow=totalNotice;
	}
	
	//페이징 관련 정보(시작행번호, 종료행번호)와 게시글 조회기능 관련 정보(조회대상과 조회단어)를
	//전달받아 NOTICE 테이블에 저장된 행에서 조회정보가 포함된 행을 페이징 처리로 검색하여
	//List 객체를 반환하는 NoticeDAO 클래스의 메소드 호출
	List<NoticeDTO> noticeList=NoticeDAO.getDAO().selectNoticeList(startRow, endRow, search, keyword);
	
	//세션에 저장된 권한 관련 정보가 저장된 속성값을 객체로 반환받아 저장
	// => 로그인 사용자에게만 글쓰기 권한 제공
	// => 게시글이 비밀글인 경우 로그인 사용자가 게시글 작성자이거나 관리자인 경우에만 권한 제공
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//서버의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 SimpleDateFormat 객체에 저장된
	//패턴의 문자열로 변환하여 저장
	// => 게시글의 작성날짜와 비교하여 게시글 작성날짜를 다르게 출력되도록 응답 처리
	String currentDate=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	
	//게시글에 출력될 일련번호 시작값을 계산하여 저장
	// => 게시글의 총갯수가 91개인 경우 => 1Page : 91, 2Page : 81, 3Page : 71, ...\
	int displayNum=totalNotice-(pageNum-1)*pageSize;
%>
--%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/common.css">
<link rel="stylesheet" type="text/css" href="../css/font.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css" href="../css/slick-theme.css">
<link rel="icon" href="../images/logo_favicon.png"/>
<link rel="apple-touch-icon" href="../images/logo_favicon.png"/>

<link rel="stylesheet" href="../css/notice_list_style.css">

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
                                <button type="button" class="btn_write" onclick="gb_btn_write('goodsqa')">
                                    <strong>1:1 문의하기</strong>
                                </button>
                            </div>
                    <div class="board_zone_con">
                        <div class="board_zone_list">
                            <div class="date_check_box">

                            </div>
                            <div class="board_list_qa">
                                <table class="board_list_table" style="width: 100%;">
                                    <thead>
                                        <tr>
                                            <th class="board_date">문의날짜</th>
                                            <th class="board_category">카테고리</th>
                                            <th class="board_title">제목</th>
                                            <th class="board_writer">작성자</th>
                                            <th class="board_state">문의상태</th>
                                            <th class="board_reply_time">답변시간</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr style="height: 10px;">
                                            <td>2024-07-11</td>
                                            <td>상품</td>
                                            <td class="board_tit">문의 제목이 들어갈 자리입니다.</td>
                                            <td>홍길동</td>
                                            <td>답변완료</td>
                                            <td>2024-07-14</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="pagination">
                                <ul>
                                    <li class="on">
                                        <span>1</span>
                                    </li>
                                    <li>
                                        <span>2</span>
                                    </li>
                                    <li>
                                        <span>3</span>
                                    </li>
                                    <li>
                                        <span>4</span>
                                    </li>
                                    <li>
                                        <span>5</span>
                                    </li>
                                </ul>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>