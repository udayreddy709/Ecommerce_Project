// import axios from "axios"
import { useState } from "react"
import "../Styles/UserUpdate.css"
import axios from "axios"

const UpdateUser = () => {
  let [name, setName] = useState("")
  let [email, setEmail] = useState("")
  let [gender, setGender] = useState("")
  let [password, setPassword] = useState("")
  let [phone, setPhone] = useState("")
  let [age, setAge] = useState("")


  let data = { name, email, gender, phone, password, age, }

  let addUser = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8080/users", data)
      .then((res) => {
        console.log(res);
        alert("Data Added Successfully")
      })
      .catch((err) => {
        console.log(err);
        alert("Data Not Found")
      })
  }
  return (
    <div className="userupdate">
      <form onSubmit={addUser}  action="">
        <label htmlFor="">Name</label>
        <input value={name} onChange={(e) => { setName(e.target.value) }} type="text" placeholder="Enter the Name" required />
        <label htmlFor="">Email</label>
        <input value={email} onChange={(e) => { setEmail(e.target.value) }} type="email" placeholder="Enter the Email" required />
        <label htmlFor="">Gender</label>
        <input value={gender} onChange={(e) => { setGender(e.target.value) }} type="text" placeholder="Enter the Gender" required />
        <label htmlFor="">Phone</label>
        <input value={phone} onChange={(e) => { setPhone(e.target.value) }} type="tel" pattern="[0-9]{10}" placeholder="Enter the Phone No" required />
        <label htmlFor="">Password</label>
        <input value={password} onChange={(e) => { setPassword(e.target.value) }} type="password" placeholder="Enter the Password" required />
        <label htmlFor="">Age</label>
        <input value={age} onChange={(e) => { setAge(e.target.value) }} type="number" placeholder="Enter the Age" required />        
        <button className="btn btn-outline-info">Submit</button>
      </form>
    </div>
  )
}

export default UpdateUser