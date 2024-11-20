import React, { useState, useEffect } from "react";

const PasswordChange = () => {
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [isMatched, setIsMatched] = useState(true);

  useEffect(() => {
    if (password && confirmPassword) {
      setIsMatched(password === confirmPassword);
    } else {
      setIsMatched(true);
    }
  }, [password, confirmPassword]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isMatched && password) {
      alert("비밀번호 변경이 완료되었습니다.");
      setPassword("");
      setConfirmPassword("");
    } else {
      alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
    }
  };

  return (
    <div className="password-change-container">
      <div className="form-container">
        <form onSubmit={handleSubmit} className="password-change-form">
          <h1>비밀번호 변경하기</h1>
          <input
            type="password"
            placeholder="비밀번호를 입력하세요."
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <input
            type="password"
            placeholder="비밀번호를 다시 입력하세요."
            value={confirmPassword}
            onChange={(e) => setConfirmPassword(e.target.value)}
            required
          />
          {!isMatched && (
            <p className="error-message">비밀번호가 일치하지 않습니다.</p>
          )}
          <button type="submit">네, 비밀번호를 변경하겠습니다.</button>
        </form>
      </div>
      <div className="image-container">
        <img
          src="/img/mypage.png"
          alt="신선한 채소들"
          className="vegetable-image"
        />
      </div>
    </div>
  );
};

export default PasswordChange;
