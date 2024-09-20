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
        #map {
            width: 100%;
            height: 350px;
            margin-bottom: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
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
        .element .description {
            margin-top: 10px;
            font-size: 16px;
            color: #666;
            line-height: 1.6; /* 줄 간격을 좀 더 넓게 설정 */
            word-wrap: break-word; /* 긴 단어를 잘라서 표시 */
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

<!-- 카카오 맵 추가 -->
<div id="map"></div>

<!-- 게시글 요소들 -->
<div class="element">
    <h2>제주 명소 1</h2>
    <div class="description">
        제주 명소 1에 대한 설명이 여기에 들어갑니다. 이 설명은 여러 줄로 길게 나올 수 있습니다. 따라서 여러 줄에 걸쳐 나오는 텍스트가 자연스럽게 표시되도록 스타일링을 추가하였습니다. 이처럼 설명이 길어질 경우에도 줄 간격과 단어가 잘리지 않게 표시됩니다.
    </div>
    <img src="https://placekitten.com/200/300" alt="서울 명소 1 이미지">
</div>

<div class="element">
    <h2>제주 명소 2</h2>
    <div class="description">
       제주 명소 2에 대한 설명이 여기에 들어갑니다. 이 설명 역시 여러 줄로 구성될 수 있으며, 줄 간격과 단어 길이를 고려하여 적절히 표현됩니다.
    </div>
    <img src="https://placekitten.com/200/301" alt="서울 명소 2 이미지">
</div>

<!-- 카카오 맵 스크립트 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=f668f12cefa13f73e2909521572e5b72"></script>
<script>
    // 마커를 표시할 위치와 title 객체 배열입니다 
    var positions = [
        { title: '카카오', latlng: new kakao.maps.LatLng(33.450705, 126.570677) },
        { title: '생태연못', latlng: new kakao.maps.LatLng(33.450936, 126.569477) },
        { title: '텃밭', latlng: new kakao.maps.LatLng(33.450879, 126.569940) },
        { title: '근린공원', latlng: new kakao.maps.LatLng(33.451393, 126.570738) }
    ];

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
        mapOption = { 
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

    // 마커 이미지의 이미지 주소입니다
    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png";

    // 이동 경로를 그릴 좌표 배열을 저장할 배열
    var linePath = [];

    for (var i = 0; i < positions.length; i++) {
        // 마커 이미지의 이미지 크기입니다
        var imageSize = new kakao.maps.Size(36, 37);

        // 스프라이트 이미지를 사용할 경우, 이미지의 특정 위치를 지정해줘야 합니다
        var imgOptions = {
            spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 전체 크기
            spriteOrigin: new kakao.maps.Point(0, (i * 46) + 10), // 마커 번호에 해당하는 스프라이트 위치
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        };

        // 마커 이미지를 생성합니다    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].title, // 마커의 타이틀
            image: markerImage // 마커 이미지 
        });

        // 마커의 좌표를 경로 배열에 추가합니다
        linePath.push(positions[i].latlng);
    }

    // 경로를 그릴 폴리라인을 생성합니다
    var polyline = new kakao.maps.Polyline({
        path: linePath, // 선을 그릴 좌표 배열
        strokeWeight: 3, // 선의 두께
        strokeColor: '#2E2EFE', // 선의 색상
        strokeOpacity: 0.5, // 선의 불투명도
        strokeStyle: 'shortdash' // 선의 스타일
    });

    // 지도에 폴리라인을 표시합니다
    polyline.setMap(map);
</script>

</body>
</html>
