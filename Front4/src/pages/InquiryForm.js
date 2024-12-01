import React, { useState } from "react";
import '../components/css/InquiryForm.css';


const InquiryForm = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`문의 접수됨\n제목: ${title}\n내용: ${content}`);
    setTitle("");
    setContent("");
  };

  return (
    <div className="inquiry-form">
      <h1>문의 하기</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="문의 제목입니다."
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="input-title"
        />
        <textarea
          placeholder="문의 내용입니다."
          value={content}
          onChange={(e) => setContent(e.target.value)}
          className="input-content"
        ></textarea>
        <button type="submit" className="submit-button">
          제출 하기
        </button>
      </form>
    </div>
  );
};

export default InquiryForm;
