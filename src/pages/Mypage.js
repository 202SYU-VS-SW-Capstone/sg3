import React, { useState, useEffect } from 'react';
import '../components/css/Mypage.css';

const Mypage = () => {
  // 사용자 데이터 상태
  const [userName, setUserName] = useState('홍길동');
  const [profileImage, setProfileImage] = useState('/path/to/새길로고.png'); // 기본 이미지 경로
  const [welcomeMessage, setWelcomeMessage] = useState('');

  // 페이지 로드 시 사용자 데이터를 불러오는 useEffect
  useEffect(() => {
    // 실제로 API 요청을 통해 사용자 데이터를 가져오는 코드 
    const fetchUserData = async () => {
      try {
        // 예시로 하드코딩된 데이터 (실제 프로젝트에서는 API 호출 사용)
        const userData = {
          name: '홍길동',
          image: '/img/mypage.png', // 사용자가 업로드한 이미지 경로
        };

        setUserName(userData.name);
        setProfileImage(userData.image);
        setWelcomeMessage(`환영합니다 ${userData.name} 님!`);
      } catch (error) {
        console.error('사용자 데이터를 불러오는 중 오류 발생:', error);
      }
    };

    fetchUserData();
  }, []);

  // 이미지 업로드 기능
  const handleImageUpload = (event) => {
    const file = event.target.files[0];
    if (file) {
      const imageUrl = URL.createObjectURL(file); // 파일을 미리보기 위해 Blob URL 사용
      setProfileImage(imageUrl);
    }
  };

  return (
    <div className="mypage-container">
      {/* 헤더 */}
      <header className="header">
        <div className="header-logo">
          
        </div>
        <div className="welcome-text">{welcomeMessage}</div>
        <button className="logout-button">로그아웃</button>
      </header>

      {/* 마이페이지 타이틀 */}
      <h1 className="mypage-title">마이페이지</h1>
      <h2 className="mypage-subtitle">나의 정보를 확인해보세요</h2>

      {/* 프로필 이미지 */}
      <div className="hero-image">
        <img src={profileImage} alt="Hero Image" />
        {/* <input 
          type="file" 
          accept="image/*" 
          onChange={handleImageUpload} 
          className="image-upload-input"
        /> */}
      </div>

      {/* 회원 정보 섹션 */}
      <div className="user-info-section">
        <p>회원 닉네임 : {userName}</p>
        <button className="button">비밀번호 변경하기</button>
        <button className="button">닉네임 변경하기</button>
        <button className="button">사진 변경하기</button>
      </div>

      {/* 소셜 아이콘 */}
      {/* <div className="social-icons">
        <img src="facebook-icon.png" alt="Facebook" />
        <img src="linkedin-icon.png" alt="LinkedIn" />
        <img src="youtube-icon.png" alt="YouTube" />
        <img src="instagram-icon.png" alt="Instagram" />
      </div> */}

      {/* 마이페이지 기능 버튼 */}
      <div className="mypage-buttons">
        <button className="button">1:1 문의하기</button>
        <button className="button">회원탈퇴 하기</button>
      </div>

      {/* 기타 기능 */}
      <div className="extra-buttons">
        <button className="button">평가한 레시피 보기</button>
        <button className="button">작성글 보기</button>
        <button className="button">작성 댓글 보기</button>
      </div>
    </div>
  );
};

export default Mypage;
