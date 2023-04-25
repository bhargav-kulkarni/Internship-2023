import React from "react";
const DockerContainer = () => {

    const value = " Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui porro deserunt molestias reprehenderit nesciunt, praesentium sit, saepe voluptate dicta at possimus dolor exercitationem non odit rerum perspiciatis vero excepturi unde!Lorem ipsum dolor sit amet consectetur, adipisicing elit. Beatae dolorem expedita nihil veritatis atque possimus a molestiae dolore delectus. Est vitae repellat consectetur nobis id laboriosam harum non, dolor quidem."
        + "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Velit, amet? Officiis, expedita! Porro deserunt omnis adipisci impedit aut dicta dolorem qui consequuntur repellat velit non atque nostrum exercitationem, suscipit ratione."
        + "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Velit reprehenderit corporis ipsam mollitia non excepturi nesciunt corrupti debitis aspernatur esse temporibus quam porro quis, quo perspiciatis praesentium pariatur obcaecati quia!";
    return (
        <div className="container" data-spy="scroll">
            <h1>Docker Container</h1>
            <div className="form-group">
                <textarea className="form-control" id="exampleFormControlTextarea1" rows="10" value={value} disabled={true}>


                </textarea>
            </div>

        </div>

    )
}
export default DockerContainer;