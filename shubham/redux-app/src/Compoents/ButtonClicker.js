import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { bindActionCreators } from "redux";
import { actionCreators } from ".";

const ButtonClicker = () => {
    const dispatch = useDispatch();
    const actions = bindActionCreators(actionCreators, dispatch)

    return (
        <>
            <button className="btn btn-primary" onClick={() => {
                actions.buttonClick();
            }}>ButtonClicker</button>
        </>
    )
}
export default ButtonClicker;