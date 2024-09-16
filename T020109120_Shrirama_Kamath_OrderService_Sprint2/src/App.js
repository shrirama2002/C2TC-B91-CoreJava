import {BrowserRouter, Route, Routes} from 'react-router-dom';
import './App.css';
import NavBar from './Components/Navigation.jsx';
import Footer from './Components/Footer.jsx';
import ImageComponent from './Components/Home.jsx'
import About from './Components/About.jsx';
import Add from './Components/Add.jsx';
import Contact from './Components/Contact.jsx'
import UpdateOrder from './Components/UpdateOrder.jsx'
import Product from './Components/GetRequest.jsx'
import './Services/OrderService.js'
function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <NavBar/>
        <Routes>
          <Route path="/" element={<ImageComponent/>}></Route>
          <Route path="/abt" element={<About/>}></Route>
          <Route path="/cont" element={<Contact/>}></Route>
          <Route path="/pro" element={<Product/>}></Route>
          <Route path="/upd/:id" element={<UpdateOrder/>}></Route>
          <Route path="/add" element={<Add/>}></Route>
        </Routes>
        <Footer/>
      </div>
    </BrowserRouter>
  );
}

export default App;
