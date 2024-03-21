import axios from 'axios'
import React, { useState } from 'react'
import "../Styles/AddAddress.css"

const AddAddress = () => {
  let [house_number, setHouse_Number] = useState("")
  let [buildingName, setBuildingName] = useState("")
  let [landMark, setLandMark] = useState("")
  let [city, setCity] = useState("")
  let [state, setState] = useState("")
  let [country, setCountry] = useState("")
  let [address_type, setAddress_Type] = useState("")
  let [pincode, setPincode] = useState("")


  let data = {house_number, buildingName,landMark,city,state,country,address_type,pincode}
  let userdata = JSON.parse(localStorage.getItem("User"))

  let addAddress = (e) => {
      e.preventDefault();
      axios.post(`http://localhost:8080/address/${userdata.id}`, data)
        .then((res) => {
          console.log(res);
          alert("Address Added Successfully")
        })
        .catch((err) => {
          console.log(err);
          alert("Can't Add Address")
        })
    }
  return (
    <div className='address'>
       <form onSubmit={addAddress} action="">
        <label htmlFor="">House No</label>
        <input value={house_number} onChange={(e) => { setHouse_Number(e.target.value) }} type="text" placeholder="Enter the House No" required />
        <label htmlFor="">Building Name</label>
        <input value={buildingName} onChange={(e) => { setBuildingName(e.target.value) }} type="text" placeholder="Enter the Building name" required />
        <label htmlFor="">LandMark</label>
        <input value={landMark} onChange={(e) => { setLandMark(e.target.value) }} type="text" placeholder="Enter the Landmark" required />
        <label htmlFor="">City</label>
        <input value={city} onChange={(e) => { setCity(e.target.value) }} type="text"  placeholder="Enter the City" required />
        <label htmlFor="">State</label>
        <input value={state} onChange={(e) => { setState(e.target.value) }} type="text" placeholder="Enter the State" required />
        <label htmlFor="">Country</label>
        <input value={country} onChange={(e) => { setCountry(e.target.value) }} type="text" placeholder="Enter the Country" required />
        <label htmlFor="">Address_Type</label>
        <input value={address_type} onChange={(e) => { setAddress_Type(e.target.value) }} type="text" placeholder="Enter the Address type" required />
        <label htmlFor="">Pincode</label>
        <input value={pincode} onChange={(e) => { setPincode(e.target.value) }} type="number" placeholder="Enter the Pincode" required />        
        <button  className="btn btn-outline-info">Submit</button>
      </form>
    </div>
  )
}

export default AddAddress