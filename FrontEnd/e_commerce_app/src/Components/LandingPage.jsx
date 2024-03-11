import { Link } from "react-router-dom";
import "../Styles/LandingPage.css"

const LandingPage = ()=>{
  return (
    <div className="landingpage">
      <Link to="/merchant">
      <img alt="" src="https://cdn-icons-png.flaticon.com/128/8004/8004222.png"/>Merchant</Link>
      <Link to="/user">
      <img alt="" src="https://cdn-icons-png.flaticon.com/128/12661/12661325.png"/>User</Link>
    </div>
  )
}

export default LandingPage;