import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './home_page/Home';
import RegisterUser from './auth_components/RegisterUser';
import LoginUser from './auth_components/Login';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>} />
        <Route path="/register" element={<RegisterUser/>} />
        <Route path="/login" element={<LoginUser/>} />
      </Routes>
    </Router>
  );
}

export default App;
