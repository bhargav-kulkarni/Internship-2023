import React from "react";

class AddContact extends React.Component {

    state = {
        name: "",
        email: "",
    }
    add = (e) => {
        e.preventDefault();
        if (this.state.email === " " && this.state.name === " ") {
            alert("Please fill the details");
            return;
        }
        this.props.addContacthandler(this.state);
        this.setState({ name: "", email: "" })
        this.props.history.push("/")

    }

    render() {
        return (
            <div className="ui main">
                <div className="ui">
                    <h2>Add contact</h2>
                    <form className="ui form" onSubmit={this.add}>
                        <div className="field">
                            <label>Name</label>
                            <input type="text" name="name" placeholder="Name"
                                value={this.state.name}
                                onChange={(e) => {
                                    this.setState({ name: e.target.value })
                                }} />
                        </div>
                        <div className="field">
                            <label>Email</label>
                            <input type="text" name="Email" placeholder="email"
                                value={this.state.email}
                                onChange={(e) => {
                                    this.setState({ email: e.target.value })
                                }}

                            />
                        </div>
                        <div className="field">
                            <input type="Submit" name="submit" placeholder="Name" />
                        </div>

                    </form>
                </div>
            </div>
        );
    }
}

export default AddContact;