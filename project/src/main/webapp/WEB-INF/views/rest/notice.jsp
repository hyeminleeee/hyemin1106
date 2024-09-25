<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
#btnDiv {
	margin: 10px;
}

#restBoardTable {
	border: 1px solid black;
	border-collapse: collapse; 
}

#restBoardTable td, #restBoardTable th {
	border: 1px solid black;
	padding: 3px;
}

.inputDiv {
	width: 550px;
	height: 220px;
	border: 1px solid black;
	background-color: gray;
	position: absolute;
	top: 30%;
	left: 20%;
	margin-top: -40px;
	margin-left: -120px;
	padding: 5px;
	z-index: 100;
	display: none;
}

#insertWriter {
	width: 500px;
}

#insertContent {
    resize: none;  /* 크기 조정 비활성화 */
    width: 500px;  /* 고정 너비 */
    height: 150px; /* 고정 높이 */
}
</style>
</head>
<body>
    <h1>공지사항</h1>
	<hr>
	<div id="btnDiv">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	
	<!--<%-- 게시글 목록을 출력하는 태그 --%>-->
	<div id="noticeListDiv"></div>

	<!--<%-- 페이지 번호를 출력하는 태그 --%>-->
	<div id="pageNumDiv"></div>
	
	<!--<%-- 신규 게시글을 입력받기 위한 태그 --%>-->
	<div id="insertDiv" class="inputDiv">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" id="insertTitle" class="insert"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="insertContent" class="insert" rows="10" cols="50" maxlength="1000"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="insertBtn">저장</button>
					<button type="button" id="cancelInsertBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	noticeListDisplay();
	
	function noticeListDisplay() {
		$.ajax({
			type: "get",
			url: "<c:url value="/rest/notice_list"/>",
			dataType: "json",
			success: function(result) {
				alert(result);
				
				if(result.noticeList.length == 0){
					var html="<div>";
					html+="<h3>공지사항이 없습니다.</h3>";
					html+="</div>"
					$("#noticeListDiv").html(html);
					return;
				}
				
				var html="<div>";
				$(result.noticeList).each(function() {
					html += '<a href="/rest/notice_view/' + this.no + '">' + this.title + '</a>';
				});
				html+="</div>";0
			},
			error:function(xhr){
				alert("에러코드(공지사항 목록) = "+xhr.status);
			}
		});
	}
	
	function init() {
		$(".insert").val("");
		$(".inputDiv").hide();
	}
	
	$("#writeBtn").click(function() {
		init();
		$("#insertDiv").show();
	});
	
	$("#cancelInsertBtn").click(init);
	
	$("#insertBtn").click(function(){
		var title=$("#insertTitle");
		var content=$("#insertContent");
		
		if(title == ""){
			alert("제목을 입력해주세요.");
			return;
		}

		if(content == ""){
			alert("내용을 입력해주세요.");
			return;
		}
		
		$.ajax({
			type: "post",
			url: "<c:url value="/rest/notice_add"/>",
			contentType: "application/json",
			data: JSON.stringify({"title":title, "content":content}),
			dataType: "text",
			success: function(result) {
				if(result == "success") {
					init();
					boardListDisplay(page, 5);
				}
			},
			error: function(xhr) {
				alert("에러코드(게시글 삽입) = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>



























