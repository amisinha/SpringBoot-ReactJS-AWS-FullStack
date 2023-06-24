import './App.css';
import {BrowserRouter, Routes, Route } from 'react-router-dom';
import HeaderComponent from './Components/HeaderComponent';
import ListTaskCompoments from './Components/ListTaskCompoments';
import AddTaskComponent from './Components/AddTaskComponent';
//import 'bootstrap/dist/css/bootstrap.min.css';


function App() {
  return (
    <div>
      <BrowserRouter>
      <HeaderComponent/>
      <div className='container'>
        <Routes>
          <Route path='/' element={<ListTaskCompoments/>}></Route>
          <Route path='/tasks' element={<ListTaskCompoments/>}></Route>
          <Route path='/add-task' element={<AddTaskComponent/>}></Route>
          <Route path = "/edit-task/:task_id" element = {<AddTaskComponent/>}></Route>
        </Routes>
      </div>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
