import Form from 'react-bootstrap/Form';
import "../Styles/UserLogin.css"
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
const UserLogin = () => {
  let [email,setEmail] = useState("")
  let [password, setPassword] = useState("")
  let navigate = useNavigate()

  function verifyUser (e){
    e.preventDefault();
    axios.post(`http://localhost:8080/users/verify-by-email?email=${email}&password=${password}`)
    .then((res)=>{
      navigate('/userhomepagee')
      localStorage.setItem("User",JSON.stringify(res.data.body))
      console.log(res.data.body);
      alert("login successfull")
    })
    .catch((err)=>{
      console.log(err.data);
      alert("Invalid Credentials")
    })
  }


  return (
    <div className='UserLogin'>
      {/* <h1>User Login</h1> */}
      <Form>
        <Form.Group className="mb-3" controlId="formGroupEmail">
          <Form.Label>Email address</Form.Label>
          <Form.Control value={email} onChange={(e)=>{setEmail(e.target.value)}} type="email" placeholder="Enter email" />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formGroupPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control value={password} onChange={(e)=>{setPassword(e.target.value)}} type="password" placeholder="Password" />
        </Form.Group>
        <Form.Group>
          <button onClick={verifyUser} className='btn btn-success mx-5'>Sign-In</button>
          <button className='btn btn-danger mx-5'><Link to="/usersignup">Sign-Up</Link></button>
        </Form.Group>
      </Form>
    </div>
  )
}

export default UserLogin