<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - List</h1>
	<hr>
	<%-- Scope 속성값이 List 객체인 경우 배열 요소값을 제공받아 출력하기 위해 첨자 사용 --%>
	<%-- => . 연산자 대신 [] 연산자에 첨자를 사용해 List 객체의 요소값을 제공받아 --%>
	<%-- <p>모델명 = ${carList.0.modelName }, 색상 = ${carList.0.carColor }</p> --%>
	<%-- <p>모델명 = ${carList[0]["modelName"] }, 색상 = ${carList[0]["carColor"] }</p> --%>
	<p>모델명 = ${carList[0].modelName }, 색상 = ${carList[0].carColor }</p>
	<p>모델명 = ${carList[1].modelName }, 색상 = ${carList[1].carColor }</p>
	<p>모델명 = ${carList[2].modelName }, 색상 = ${carList[2].carColor }</p>
	<p>모델명 = ${carList[3].modelName }, 색상 = ${carList[3].carColor }</p>
	<p>모델명 = ${carList[4].modelName }, 색상 = ${carList[4].carColor }</p>
</body>
</html>