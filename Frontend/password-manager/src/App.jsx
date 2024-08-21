import { useEffect, useState } from 'react'
// import './App.css'
import axios from 'axios';
import RegisterUser from './auth_components/RegisterUser';

function App() {
  // const [myData, setMyData]=useState("");
  // useEffect(()=>{
  //   axios
  //   .get("http://localhost:8080/api/welcome")
  //   .then((res)=>
  //     setMyData(res.data)
  // );  
  // },[]);
  return (
    <div>
      <RegisterUser/>
    </div>
  )
}

export default App
