import React, { useState, useEffect } from "react";

const Withdrawal = () => {
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [isMatched, setIsMatched] = useState(true);

  // 비밀번호와 확인 비밀번호 일치 여부를 확인
  useEffect(() => {
    if (password && confirmPassword) {
      setIsMatched(password === confirmPassword);
    } else {
      setIsMatched(true); // 입력이 없으면 경고 숨김
    }
  }, [password, confirmPassword]);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (isMatched && password) {
      alert("탈퇴가 완료되었습니다.");
    } else {
      alert("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
    }
  };

  return React.createElement(
    "div",
    { className: "withdrawal-container" },
    React.createElement("h1", null, "탈퇴하기"),
    React.createElement(
      "form",
      {
        className: "withdrawal-form",
        onSubmit: handleSubmit,
      },
      React.createElement("input", {
        type: "password",
        placeholder: "비밀번호를 입력하세요.",
        value: password,
        onChange: (e) => setPassword(e.target.value),
      }),
      React.createElement("input", {
        type: "password",
        placeholder: "비밀번호 확인을 위해 다시 입력하세요.",
        value: confirmPassword,
        onChange: (e) => setConfirmPassword(e.target.value),
      }),
      !isMatched &&
        React.createElement(
          "p",
          { className: "error-message" },
          "비밀번호가 일치하지 않습니다."
        ),
      React.createElement(
        "button",
        { type: "submit" },
        "네, 탈퇴하겠습니다."
      )
    ),
    React.createElement(
      "div",
      { className: "image-container" },
      React.createElement("img", {
        src: "/img/mypage.png", // 이미지 경로 변경 가능
        alt: "신선한 채소들",
      })
    )
  );
};

export default Withdrawal;
