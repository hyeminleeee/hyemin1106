<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>여러개 마커 경로 표시하기</title>
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div>

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
    strokeColor: '#2E2EFE', // 선의 색상 (빨간색)
    strokeOpacity: 0.5, // 선의 불투명도
    strokeStyle: 'shortdash' // 선의 스타일
});

// 지도에 폴리라인을 표시합니다
polyline.setMap(map);

</script>
</body>
</html>