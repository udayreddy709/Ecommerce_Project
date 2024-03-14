// import React from 'react'
// import MerchantHomePagee from './MerchantHomePagee'
import { Navigate } from 'react-router-dom'


const Protect = ({Child}) => {
  let x = localStorage.getItem("Merchant")
  let verifyProtect = () => {
    if (x == null) {
      return false
    }
    else {
      return true
    }
  }
  return (
    <div>
      {verifyProtect() ? <Child/> : <Navigate to="/merchant"/>}
    </div>
  )
}

export default Protect