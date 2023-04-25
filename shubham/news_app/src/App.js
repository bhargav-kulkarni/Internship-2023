import { useState } from "react";
import React from "react";
import About from "./Compoents/About";
import NavBar from "./Compoents/navBar/NavBar";
import NewsCompoent from "./Compoents/NewsCompoent";

import { BrowserRouter, Router, Switch, Routes, Route } from "react-router-dom";
import NewsDetails from "./Compoents/NewsDetails";



function App() {


  return (
    <>

      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route exact path="/" key="Home" element={<NewsCompoent country={"in"} category={"general"} />} />
          <Route exact path="/About" key="About" element={<About />} />
          <Route exact path="/business" key="businness" element={<NewsCompoent country={"in"} category={"business"} />} />
          <Route exact path="/entertainment" key="entertainment" element={<NewsCompoent country={"in"} category={"entertainment"} />} />
          <Route exact path="/health" key="health" element={<NewsCompoent country={"in"} category={"health"} />} />

          <Route exact path="/science" key="science" element={<NewsCompoent country={"in"} category={"science"} />} />

          <Route exact path="/sports" key="sports" element={<NewsCompoent country={"in"} category={"sports"} />} />

          <Route exact path="/technology" key="technology" element={<NewsCompoent country={"in"} category={"technology"} />} />


        </Routes>
      </BrowserRouter>

    </>
  );
}

export default App;
