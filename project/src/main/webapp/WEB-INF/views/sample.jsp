<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .post-header {
            padding: 15px;
            background-color: #fff;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
        }
        .post-title {
            font-size: 24px;
            font-weight: bold;
            color: #333;
            margin-bottom: 5px;
        }
        .post-author {
            font-size: 14px;
            color: #666;
            margin-bottom: 10px;
            display: flex;
            align-items: center;
        }
        .post-author::before {
            content: '👤';
            margin-right: 5px;
            font-size: 16px;
        }
        .post-meta {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 14px;
            color: #999;
            margin-top: 10px;
        }
        .post-meta .date {
            display: flex;
            align-items: center;
            color: #666;
        }
        .post-meta .date::before {
            content: '📅';
            margin-right: 5px;
            font-size: 16px;
        }
        .post-actions {
            display: flex;
            align-items: center;
        }
        .post-actions span {
            margin-left: 10px;
            font-size: 14px;
            color: #666;
        }
        .post-actions i {
            margin-right: 3px;
            font-style: normal;
        }
        .post-actions .views::before {
            content: '👁';
        }
        .post-actions .comments::before {
            content: '💬';
        }
        .post-actions .likes::before {
            content: '👍';
        }
        .element {
            background-color: white;
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
        }
        .element h2 {
            margin: 0;
            font-size: 18px;
            color: #333;
        }
        .element img {
            width: 500px;
            height: 250px;
            object-fit: cover;
            margin-top: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>

<!-- 게시글 상단 정보 -->
<div class="post-header">
    <div class="post-title">제주 여행 추천</div>
    <div class="post-author">바삭바삭</div>
    <div class="post-meta">
        <span class="date">2024-09-19</span>
        <div class="post-actions">
            <span class="views">5024</span>
            <span class="comments">72</span>
            <span class="likes">3028</span>
        </div>
    </div>
</div>

<!-- 게시글 요소들 -->
<div class="element">
    <h2>서울 명소 1</h2>
    <p>서울 명소 1에 대한 설명이 여기에 들어갑니다.</p>
    <img src="https://placekitten.com/200/300" alt="서울 명소 1 이미지">
</div>

<div class="element">
    <h2>서울 명소 2</h2>
    <p>서울 명소 2에 대한 설명이 여기에 들어갑니다.</p>
    <img src="https://placekitten.com/200/301" alt="서울 명소 2 이미지">
</div>

</body>
</html>
