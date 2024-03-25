import { Link } from "react-router-dom";
import "../Styles/MerchantNavBar.css";
import Dropdown from 'react-bootstrap/Dropdown';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

const MerchantNavBar = () => {
  return (
    <nav className="merchantnavbar">
      <div className="logo">
        <h1>Athena</h1>
      </div>
      <div className="option">
        <Link to="/merchanthomepagee/productview">View Products</Link>
        <Link to="/merchanthomepagee/addproduts">Add Products</Link>
      </div>
      <div>
        <Dropdown>
          <Dropdown.Toggle variant="outline-info" id="dropdown-basic">
            <AccountCircleIcon />   Account
          </Dropdown.Toggle>

          <Dropdown.Menu className="dropmenu">
            <Dropdown.Item className="dropitem" href="/merchanthomepagee/updatemerchant">Update</Dropdown.Item>
            <Dropdown.Item className="dropitem" href="/">Log-Out</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>
      </div>

    </nav>

  )
}

export default MerchantNavBar;