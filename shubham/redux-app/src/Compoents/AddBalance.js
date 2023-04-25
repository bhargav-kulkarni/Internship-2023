import React from "react";
import { useDispatch } from "react-redux";
import { actionCreators } from ".";
import { bindActionCreators } from "redux";

const AddBalance = () => {
    const dispatch = useDispatch();
    const actions = bindActionCreators(actionCreators, dispatch)
    return (
        <>
            <div className="container my-3">
                <button class="btn btn-primary my-3 my-sm-0 mx-5"
                    onClick={() => {
                        actions.deposite(100)
                    }}>+</button>
                <span className="my-3">Add Balance</span>
                <button class="btn btn-primary my-3 my-sm-0 mx-5" onClick={() => {
                    actions.withdraw(100)
                }

                }>-</button>
            </div >
        </>
    )
}

export default AddBalance;