<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.NoticeDAO"%>
<%@page import="xyz.itwill.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		
	int noticeNum=Integer.parseInt(request.getParameter("noticeNum"));
	String pageNum=request.getParameter("pageNum");
	String pageSize=request.getParameter("pageSize");
	String search=request.getParameter("search");
	String keyword=request.getParameter("keyword");
	
	NoticeDTO notice=NoticeDAO.getDAO().selectNoticeByNum(noticeNum);
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	NoticeDAO.getDAO().updateNoticeCount(noticeNum);
--%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/notice_detail_style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<title>공지사항</title>
</head>
<body>
	<div id="container">
			<div id="contents">
				<div class="sub_content">
					<div class="content">
						<div class="board_zone_sec">
							<div class="board_zone_tit">
								<h2>공지사항</h2>
							</div>
							<div class="board_zone_cont">
								<div class="board_zone_view">
									<div class="board_view_tit">
										<h3>제목이 들어갈 자리입니다.</h3>
									</div>
									<div class="board_view_info">
										<span class="view_info_idip">
											<strong>관리자</strong>
										</span>
										<span class="view_info_day">
											<em>2024.07.22 13:25:56</em>
										</span>
										<span class="view_info_hits">
											<strong>조회수</strong>
											300
										</span>
									</div>
									<div class="board_view_content">
										<div class="seem_cont">
											<div style="margin: 10px 0 10px 0;">
												<p>
													<img src="images/deliverey_schedule.png">
													<br style="clear:both">
												</p>
											</div>
										</div>
									</div>
									<div class="board_view_comment">
										<div class="view_comment"></div>
									</div>
								</div>
								<div class="btn_right_box">
									<button type="button" class="btn_board_list">
										<strong>목록</strong>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
	$("#writeBtn").click(function() {
		location.href="<%=request.getContextPath()%>/index.jsp?workgroup=board&work=notice_list";
	});
	</script>
</body>
</html>