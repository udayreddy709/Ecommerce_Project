import React from 'react'
import { Route, Routes } from 'react-router-dom'
import ProductView from './ProductView'
import UserNavBar from './UserNavBar'
import AddAddress from './AddAddress'

const UserHomePage = () => {
  return (
    <div className='uhp'>
      <UserNavBar />
      <Routes>
        <Route path="productview" element={<ProductView />} />
        <Route path="addaddress" element={<AddAddress />} />
      </Routes>
    </div>
  )
}

export default UserHomePage