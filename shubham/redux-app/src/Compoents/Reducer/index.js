import { combineReducers } from "redux"
import amountReducer from "./amountReducer"

import clickReducer from "./clickReducer"

const reducers = combineReducers({
    amount: amountReducer,
    clickData: clickReducer
})

export default reducers;