import './App.css';
import Sidebar from './Sidebar';
import HomeMap from './HomeMap';
import { BrowserRouter as Router, Routes, Route, useLocation } from "react-router-dom";
import { AddRestroom } from './components/AddRestroom';
import { RequestEditing } from './components/RequestEditing';
import { MyReview } from './components/MyReview';
import { MyAccount } from './components/MyAccount';
import { AddReview } from './components/AddReview';

function App() {

    const location = useLocation();
    const background = location.state && location.state.background;

    return (
      <div className = "App">

          <Sidebar />


            <Routes>
              <Route path="/" element={<HomeMap />} />
            </Routes>
          
          <div className="AddRestroom">
            {background && (
              <Routes>
                <Route path="addRestroom" element={<AddRestroom />} />
              </Routes>
            )}
          </div>

          <div className="RequestEditing">
            {background && (
              <Routes>
                <Route path="requestEditing" element={<RequestEditing />} />
              </Routes>
            )}
          </div>

          <div className="MyReview">
            {background && (
              <Routes>
                <Route path="myReview" element={<MyReview />} />
              </Routes>
            )}
          </div>

          <div className="RequestEditing">
            {background && (
              <Routes>
                <Route path="myAccount" element={<MyAccount />} />
              </Routes>
            )}
          </div>

          <div className="AddReview">
            {background && (
              <Routes>
                <Route path="reviews" element={<AddReview />} />
              </Routes>
            )}
          </div>
      </div>
    )
}
export default App;