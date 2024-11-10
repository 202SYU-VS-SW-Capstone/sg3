import React from 'react';
import './css/Footer.css';

const Footer = () => {
  return (
    <footer>
      <div className="company-info">새길 © 2024</div>
      <p>서비스를 제공합니다. 모든 권리 보유.</p>
      <div className="social-links">
        <a href="#">Facebook</a> | <a href="#">Twitter</a> | <a href="#">LinkedIn</a>
      </div>
    </footer>
  );
};

export default Footer;
