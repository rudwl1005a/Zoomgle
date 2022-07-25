import { Route, Routes } from "react-router-dom";
import './App.css'
import StartPage from "./pages/StartPage";
import MyPage from "./pages/MyPage";
import ProfilePage from "./pages/ProfilePage";
import FriendsPage from "./pages/FriendsPage";
import PicturesPage from "./pages/PicturesPage";
import JoinGamePage from "./pages/JoinGamePage";
import SignupPage from "./pages/SignupPage";
import LoginPage from "./pages/LoginPage";


const App = () => {
  return (
    <Routes>      
      <Route path='/' element={<StartPage />} />
      <Route path='/signup/' element={<SignupPage />} />
      <Route path='/login/' element={<LoginPage />} />
      <Route path='/mypage/' element={<MyPage />} />
      <Route path='/profile/' element={<ProfilePage />} />
      <Route path='/friends/' element={<FriendsPage />} />
      <Route path='/pictures/' element={<PicturesPage />} />
      <Route path='/joingame/' element={<JoinGamePage />} />
    </Routes>
  );
};

export default App;