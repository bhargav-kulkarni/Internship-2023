import React from "react";
import { Link } from "react-router-dom";

const ContactCard = (props) => {
    const { id, name } = props.contact;
    return (
        <div className="item">
            <div className="content">
                <div className="header">{id}</div>
                <Link to="/contact/${id}">
                    <div className="header">{name}</div>
                </Link>
            </div>
            <i className="trash alternate outline icon"
                style={{ color: "red", marginTop: "7px" }}
                onClick={() => props.clickHandler(id)}
                key={id}
            >

            </i>


        </div>

    )
}
export default ContactCard;