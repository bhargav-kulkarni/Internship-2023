import React from "react";
import { useSelector } from "react-redux";

const DisplayData = () => {
    const state = useSelector(state => state);
    const amount = useSelector(state => state.amount);

    console.log(state)

    return (
        <>

            <h1>{state.clickData}</h1>

            <h1>{state.amount}</h1>
        </>
    )
}

export default DisplayData;