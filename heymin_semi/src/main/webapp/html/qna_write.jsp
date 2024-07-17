<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/qna_write_style.css">

<title>상품문의 쓰기</title>
</head>
<body>
<div id="container">
	<div id="contents">
        <div class="sub_content">
            <div class="content">
                <div class="board_zone_sec">
                    <div class="board_zone_tit">
                        <h2>상품문의</h2>
                    </div>
                    <div class="board_zone_cont">
						<!--<form name="frmWrite" id="frmWrite" action="#" method="post" enctype="#" class="frmWrite" novalidate="novalidate">
							<input type="hidden" name="bdld" value="goodsqa">
							<input type="hidden" name="sno" value=>
							<input type="hidden" name="mode" value="write">
							<input type="hidden" name="returnUrl" value="bdld=goodsqa">-->
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
														<select class="tune" id="category" name="category" style="width: 127px;">
															<option value>문의내용</option>
															<option value="상품">상품</option>
															<option value="배송">배송</option>
															<option value="반품/환불">반품/환불</option>
															<option value="교환/변경">교환/변경</option>
															<option value="기타">기타</option>
														</select>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">작성자</th>
												<td>
													<input type="text" id="writer" class="writer_name">
												</td>
											</tr>
											<tr>
												<th scope="row">상품 선택</th>
												<td>
													<div class="board_goods_select">
														<span>선택된 상품이 없습니다.</span>
														<a href="#" title="찾아보기" class="btn_goods_select btn_open_layer">상품 선택</a>
													</div>
												</td>
											</tr>
											<tr>
												<th scope="row">휴대폰</th>
												<td>
													<input type="text" id="time" class="write_title" name="writerMobile" value placeholder="- -없이 입력하세요" autocomplete="off">
												</td>
											</tr>
											<tr>
												<th scope="row">제목</th>
												<td>
													<input type="text" name="subject" value>
												</td>
											</tr>
											<tr>
												<th scope="row">본문</th>
												<td class="write_editor">
													<div class="form_element">
														<em>해당글은 비밀글로만 작성이 됩니다.</em>
													</div>
													<textarea class="content_editor" name="contents" cols="30" rows="10">

													</textarea>
													<!--<input type="text" class="content_text">-->
												</td>
											</tr>
											<tr>
												<th scope="row">첨부파일</th>
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
											<tr>
												<th scope="row">자동등록방지</th>
												<td>
													<div class="capcha">
														<div class="capcha_img">
															<img src="/images/captcha.php" id="captchaImg" alt="자동등록방지 이미지">
														</div>
														<div class="capcha_txt">
															<p>
																보이는 순서대로
																<br>
																숫자 및 문자를 모두 입력해 주세요.
															</p>
															<input type="text" class="text captcha" name="captchaKey" maxlength="5">
															<span class="btn_gray_list">
																<button type="button" class="btn_gray_small">
																	<span>
																		<img src="../images/refresh.png" alt="이미지 새로고침">
																		이미지 새로고침
																	</span>
																</button>
															</span>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
							<div class="order_view_info">
								<div class="order_agree">
									<div class="order_zone_title">
										<h4>비회원 개인정보 수집동의</h4>
										<div class="agreement_box">
											주식회사 캠핑퍼스트는 비회원의 게시글 등록 시 콘텐츠 등록 및 고객 문의 응대 등을 원활하게 진행하기 위해 아래와 같은 개인정보를 수집하고 있습니다.
											<br>
											<br>
											- 수집항목: 이름, 비밀번호,닉네임,휴대폰번호,이메일,IP
											<br>
											- 수집/이용목적: 게시글 접수 및 결과 회신
											<br>
											- 이용기간: 개인정보 수집 및 이용목적 달성 시 까지
											<br>
											<br>
											원칙적으로 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 
											<br>
											단, 관계법령의 규정에 의하여 보전할 필요가 있는 경우 일정기간 동안 개인정보를 보관할 수 있습니다.
											<br>
											그 밖의 사항은 법령상의 개인정보처리방침을 준수합니다.
										</div>
										<div class="form_element">
											<input type="checkbox" class="require">
											<label class="check_s">
												비회원 글작성에 대한 개인정보 수집 및 이용동의
												<strong>전체보기></strong>
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="btn_center_box">
								<button type="button" class="btn_before">
									<strong>이전</strong>
								</button>
								<button type="submit" class="btn_write_ok">
									<strong>저장</strong>
								</button>
							</div>
						<!--</form>-->
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>
</body>
</html>