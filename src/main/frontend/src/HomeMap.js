import React, { useEffect, useRef } from 'react';

function HomeMap() {
  const mapElement = useRef(null);

  useEffect(() => {
    const { naver } = window;
    if (!mapElement.current || !naver) return;

    // Geolocation API를 사용하여 사용자의 현재 위치 정보를 가지고 옴
    navigator.geolocation.getCurrentPosition(
      (position) => {
        const { latitude, longitude } = position.coords;

        // 현재 위치의 좌표 생성
        const location = new naver.maps.LatLng(latitude, longitude);

        const mapOptions = {
          center: location,
          zoom: 18,
          zoomControl: true,
          zoomControlOptions: {
            position: naver.maps.Position.TOP_RIGHT,
          },
        };
        const map = new naver.maps.Map(mapElement.current, mapOptions);

        // 현재 위치에 마커 표시
        new naver.maps.Marker({
          position: location,
          map,
        });
      },
      (error) => {
        console.error('Error getting user location:', error);
      }
    );
  }, []);

  return <div ref={mapElement} style={{ width: '100%', height: '100vh' }} />;
}

export default HomeMap;