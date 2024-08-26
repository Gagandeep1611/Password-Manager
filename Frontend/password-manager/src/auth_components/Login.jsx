import React, { useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './LoginUser.css'; // Import the custom CSS file

function LoginUser() {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post('http://localhost:8080/auth/login', formData);
      console.log('Login successful:', response.data);
      // Handle success, e.g., redirect or show a success message
    } catch (error) {
      console.error('There was an error logging in!', error);
      // Handle error, e.g., show an error message
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center align-items-center">
        <div className="col-md-4 text-center text-md-start">
          <h1 className="display-4">Password Manager</h1>
          <p className="text-muted">by Gagandeep Singh</p>
          <Link to="/" className="btn btn-dark text-white mt-3">Home</Link>
        </div>
        <div className="col-md-6 offset-md-1">
          <div className="text-center mb-4">
            <h2>Welcome Back!</h2>
            <p className="lead">Login to Continue</p>
          </div>
          <div className="card custom-card">
            <div className="card-body">
              <form onSubmit={handleSubmit}>
                <div className="form-group mb-3">
                  <label htmlFor="email">Email:</label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    required
                  />
                </div>
                <div className="form-group mb-3">
                  <label htmlFor="password">Password:</label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                  />
                </div>
                <button type="submit" className="btn btn-dark w-100 mb-2">Login</button>
                <Link to="/register" className="btn btn-link">Don't have an account? Register</Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default LoginUser;
