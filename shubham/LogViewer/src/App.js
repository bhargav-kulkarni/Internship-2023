import React from "react";
import NavBar from "./Compoents/NavBar";
import DockerImages from "./Compoents/DockerImages";
import DockerContainer from "./Compoents/DockerContainer";
import LogViewer from "./Compoents/LogViewer";
import Footer from "./Compoents/Footer";

function App() {


  return (
    <>
      <NavBar />
      <DockerImages />
      <LogViewer />
      <Footer />

    </>
  );
}

export default App;
