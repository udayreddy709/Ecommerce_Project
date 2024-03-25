import React from 'react'
import { Route, Routes } from 'react-router-dom'
import UserNavBar from './UserNavBar'
import AddAddress from './AddAddress'
import  UserProductView from "./UserProductView";


const UserHomePage = () => {
  return (
    <div className='uhp'>
      <UserNavBar />
      <Routes>
        <Route path="addaddress" element={<AddAddress />} />
        <Route path="/" element={<UserProductView/>}/>
      </Routes>
    </div>
  )
}

export default UserHomePage