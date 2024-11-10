import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MainLayout from './layouts/MainLayout';
import Home from './components/Home';     
import Contact from './pages/Contact';
import Header from './components/Header';   
import Footer from './components/Footer';   
import Login from './pages/Login';
import Signup from './pages/Signup';
import Mypage from './pages/Mypage';
import Recipe from './pages/Recipe';



function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainLayout><Home /></MainLayout>} />
        <Route path="/login" element={<MainLayout><Login /></MainLayout>} />
        <Route path="/signup" element={<MainLayout><Signup /></MainLayout>} />
        <Route path="/mypage" element={<MainLayout><Mypage /></MainLayout>} />
        <Route path="/recipe" element={<MainLayout><Recipe /></MainLayout>} />

      </Routes>
    </Router>
  );
}

export default App;
