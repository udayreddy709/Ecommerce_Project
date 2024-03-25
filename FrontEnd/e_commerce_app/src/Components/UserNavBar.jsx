import React from 'react'
import "../Styles/UserNavBar.css"
import Dropdown from 'react-bootstrap/Dropdown';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
// import { Link } from 'react-router-dom';

const UserNavBar = () => {
  return (
    <nav className="navbar">
    <div className="logo">
      <h1>UserHomePage</h1>
    </div>
    <div className="option">
      {/* <Link to="/merchanthomepagee/productview">View Products</Link> */}
    </div>
    <div>
    <Dropdown>
    <Dropdown.Toggle variant="outline-info"  id="dropdown-basic">
      <AccountCircleIcon/>   Account
    </Dropdown.Toggle>

    <Dropdown.Menu>
      <Dropdown.Item href='/userhomepagee/addaddress'>Add Address</Dropdown.Item>
      <Dropdown.Item href="/">Log-Out</Dropdown.Item>

    </Dropdown.Menu>
  </Dropdown>
    </div>
    
  </nav>

  )
}

export default UserNavBar