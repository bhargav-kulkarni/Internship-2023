const reducer = (state = 0, action) => {
    if (action.type === 'Clicker') {
        return state + 1
    }
    else {
        return state
    }
}
export default reducer