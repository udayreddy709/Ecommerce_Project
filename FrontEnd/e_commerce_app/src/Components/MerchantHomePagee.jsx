import { Route, Routes } from "react-router-dom"
import ProductView from "./ProductView"
import MerchantNavBar from "./MerchantNavBar"
import UpdateMerchant from "./UpdateMerchant"
import AddProducts from "./AddProducts"
import UpdateProducts from "./UpdateProducts"

const MerchantHomePagee = () => {
  return (
    <div className="mhp">
      <MerchantNavBar/>
      <Routes>
        <Route path="/productview" element={<ProductView/>}/>
        <Route path="/updatemerchant" element={<UpdateMerchant/>}/>
        <Route path="/addproduts" element={<AddProducts/>}/>
        <Route path="/updateproduct/:id" element={<UpdateProducts/>}/>
      </Routes>
    </div>
  )
}

export default MerchantHomePagee