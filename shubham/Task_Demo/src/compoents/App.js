import './App.css';
import React from 'react';

import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState, useEffect } from 'react';
import AddContact from './AddContact';
import ContactList from './contactList'
import Home from './Home';

function App() {
  const [contact, setContact] = useState([]);
  const LOCAL_STORAGE_KEY = "contact";
  const addContacthandler = (contact1) => {
    console.log(contact1)
    setContact([...contact, contact1])

  };



  return (
    <BrowserRouter>
      <Routes>



        <Route path="/"


          render={(props) => {
            <ContactList
              {
              ...props
              }
              contacts={contact}
            />
          }}
        />
        <Route path="/AddContact" element={<AddContact addContacthandler={addContacthandler} />}>
        </Route>




      </Routes>
      <ContactList contacts={contact} />
    </BrowserRouter >


  );
}

export default App;
