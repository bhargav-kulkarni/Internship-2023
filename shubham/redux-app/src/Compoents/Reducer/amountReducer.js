const reducer = (state = 0, action) => {
    console.log("withdrawsad" + action.type)
    if (action.type === 'deposite') {
        return state + action.payload
    }
    else if (action.type === 'withdraw') {
        return state - action.payload
    }
    else {
        return state
    }
}
export default reducer