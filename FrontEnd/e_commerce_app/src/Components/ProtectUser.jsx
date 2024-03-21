import { Navigate } from 'react-router-dom'


const Protect1 = ({Child}) => {
  let x = localStorage.getItem("User")
  let verifyProtect1 = () => {
    if (x == null) {
      return false
    }
    else {
      return true
    }
  }
  return (
    <div>
      {verifyProtect1() ? <Child/> : <Navigate to="/user"/>}
    </div>
  )
}

export default Protect1