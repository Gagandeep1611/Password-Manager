import React from 'react';
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Home() {
  return (
    <div className="container mt-5">
      <div className="row justify-content-center align-items-center">
        <div className="col-md-8 text-center">
          <h1 className="display-4">Password Manager</h1>
          <p className="text-muted">by Gagandeep Singh</p>
          <div className="mt-4">
            <Link to="/register" className="btn btn-dark btn-lg mx-2">Register</Link>
            <Link to="/login" className="btn btn-dark btn-lg mx-2">Login</Link>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
