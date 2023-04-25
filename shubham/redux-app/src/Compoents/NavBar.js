import React from 'react'
import { useSelector } from 'react-redux';

const NavBar = () => {
    const amount = useSelector(state => state.amount)
    return (
        <div className="">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark" style={{ "color": "white" }}>
                <a class="navbar-brand" href="/">State Bank</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                        </li>



                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <button class="btn btn-primary my-2 my-sm-0" disabled={true}>Account Balance:{amount}</button>
                    </form>
                </div>
            </nav>
        </div>

    )
}

export default NavBar;