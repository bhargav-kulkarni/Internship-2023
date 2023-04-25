import React from "react";
import { Link } from "react-router-dom";

const NavBar = (props) => {


    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark" style={{ "width": "1280px", "color": "white" }}>


            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">

                    <li class="nav-item">
                        <Link className="nav-link" to="/">News App</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/">Home</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/About">About</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/business">business</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/entertainment">entertainment</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/health">health</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/science">science</Link>
                    </li>

                    <li class="nav-item">
                        <Link className="nav-link" to="/sports">sports</Link>
                    </li>
                    <li class="nav-item">
                        <Link className="nav-link" to="/technology">technology</Link>
                    </li>


                </ul>

            </div>
        </nav>
    );


}

export default NavBar;