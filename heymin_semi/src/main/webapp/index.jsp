<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String workgroup=request.getParameter("workgroup");
	if(workgroup == null){
		workgroup="main";
	}
	
	String work=request.getParameter("work");
	if(work == null){
		work="main_page";
	}
	
	String contentPath=workgroup+"/"+work+".jsp";
	
	String headerPath="/header.jspf";
	if(workgroup.equals("admin")) {
		headerPath="/header_admin,jsp";
	}
%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/font.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css" href="css/slick-theme.css">
<link rel="icon" href="images/logo_favicon.png"/>
<link rel="apple-touch-icon" href="images/logo_favicon.png"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>


<title>Nature Gear</title>
</head>
<body>
	<div id="mainWrap" class="wrap_main">
		<div id="head">
			<jsp:include page="<%=headerPath %>"/>
		</div>
		
		<div id="content">
			<jsp:include page="<%=contentPath %>"/>
			<%
				String returnUrl=(String)request.getAttribute("returnUrl");
				if(returnUrl != null) {
					response.sendRedirect(returnUrl);
					return;
				}
			%>
		</div>
		
		<div id="footer">
			<%@include file="footer.jspf" %>
		</div>
	</div>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>