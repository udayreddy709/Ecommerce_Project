import { Route, Routes } from "react-router-dom"
import ProductView from "./ProductView"
import MerchantNavBar from "./MerchantNavBar"
import UpdateMerchant from "./UpdateMerchant"

const MerchantHomePagee = () => {
  return (
    <div className="mhp">
      <MerchantNavBar/>
      <Routes>
        <Route path="productview" element={<ProductView/>}/>
        <Route path="updatemerchant" element={<UpdateMerchant/>}/>
      </Routes>
    </div>
  )
}

export default MerchantHomePagee