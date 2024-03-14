import { BrowserRouter, Route, Routes } from 'react-router-dom';
import LandingPage from './Components/LandingPage';
import UserLogin from './Components/UserLogin';
import MerchantLogin from './Components/MerchantLogin';
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantSignUp from './Components/MerchantSignUp';
import MerchantHomePagee from './Components/MerchantHomePagee';
import UserHomePage from './Components/UserHomePage';
import UserSignUp from './Components/UserSignUp';
import ErrorPage from './Components/ErrorPage';
import Protect from './Components/Protect';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<LandingPage />} />
          <Route path='/*' element={<ErrorPage/>}/>
          <Route path='/merchant' element={<MerchantLogin />} />
          <Route path='/user' element={<UserLogin />} />
          <Route path='/merchantsignup' element={<MerchantSignUp />} />
          <Route path='/merchanthomePagee/*' element={<Protect Child={MerchantHomePagee}/>} />
          
          <Route path='/userhomepagee' element={<UserHomePage/>}/>
          <Route path='/usersignup' element={<UserSignUp/>}/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
