var mapContainer = document.getElementById('map'), // 지도를 표시할 div
 mapOption = {
    center: new kakao.maps.LatLng(37.5679, 126.9813), // 지도의 중심좌표
    level: 11 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({
    // 지도 중심좌표에 마커를 생성합니다
    position: map.getCenter()
});
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {

    // 클릭한 위도, 경도 정보를 가져옵니다
    var latlng = mouseEvent.latLng;

    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);


    // 클릭한 위도, 경도 정보를 가져옵니다
    var latlng = mouseEvent.latLng;

    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);

    // 클릭한 위치의 위도와 경도를 가져옵니다
    var lat = latlng.getLat();
    var lng = latlng.getLng();

    fetch("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?x="+lng+"&y="+lat,{
        headers:{
            Authorization:"KakaoAK c3bd320c26840fdf683a85f5ea5bf3fc"
        }
    })
    .then(response=>response.json())
    .then(result=>{
         console.log(result)
         document.getElementById("address").value=result.documents[0].address_name
    })
});
