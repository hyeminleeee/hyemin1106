<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/notice_write_style.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

<title>공지사항 작성</title>
</head>
<body>
	<div id="container">
		<div class="notice_write_head">
			<h2>공지사항 작성</h2>
		</div>
		<div>
			<table class="notice_write_table">
				<colgroup>
					<col style="width: 15%;">
					<col style="width: 85%;">
				</colgroup>
				<tr>
					<th scope="row">제목</th>
					<td>
						<input type="text" id="notice_title">
					</td>
				</tr>
				<tr>
					<th scope="row">이미지</th>
					<td id="uploadBox">
						<div class="file_upload_sec">
							<label for="attach1">
								<input type="text" class="file_text" title="파일 첨부하기" readonly="readonly">
							</label>
							<div class="btn_upload_box">
								<button type="button" class="btn_upload" title="찾아보기">
									<em>찾아보기</em>
								</button>
								<!--<input type="file" id="attach1" name="upfiles[]" class="file" title="찾아보기">-->
								<span class="btn_gray_list">
									<button type="button" id="addUploadBtn" class="btn_gray_big">
										<span>+ 추가</span>
									</button>
								</span>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<div class="btn_center_box">
				<button type="button" class="btn_before">
					<strong>이전</strong>
				</button>
				<button type="submit" class="btn_write_ok">
					<strong>저장</strong>
				</button>
			</div>
		</div>
	</div>
</body>
</html>