import PropTypes from 'prop-types'
import React, { Component } from 'react'
const data1 = [];
export default class DockerImages extends Component {

    constructor(props) {
        super(props);
        this.state = {
            dockerImages: "",
            containerId: ""
        }

    }



    componentDidMount() {
        const dockerContainerID = []
        console.log("hi");

        fetch('http://localhost:8182/api/dockerContainer')
            .then(response => response.json())
            .then((data) => {
                let data1 = JSON.stringify(data);

                data1 = data1.replace("]", "")

                data1 = data1.replace("[", "")

                let data2 = data1.split("},");

                let dockerImages = ""

                let containerId = ""

                for (let i = 0; i < data2.length; i++) {

                    data2[i] = data2[i].replace("{", "");

                    data2[i] = data2[i].replace("}", "");

                    const data3 = data2[i].split(",")

                    dockerImages += data3[1] + "\n"

                    containerId += data3[0] + "\n"

                }

                dockerImages = dockerImages.toString().replace(/"/g, '')

                containerId = containerId.toString().replace(/"/g, "");




                this.setState({ ...this.state, dockerImages: dockerImages, containerId: containerId })
            })
            .catch(error => console.error(error));



    }

    componentDidUpdate(prevProps, prevState) {
        if (prevState.data !== this.state.data) {
            const dockerContainerID = []
            fetch('http://localhost:8181/api/dockerimages')
                .then(response => response.json())
                .then((data) => {
                    let data1 = JSON.stringify(data);

                    data1 = data1.replace("]", "")

                    data1 = data1.replace("[", "")

                    let data2 = data1.split("},");

                    let dockerImages = ""

                    let containerId = ""

                    for (let i = 0; i < data2.length; i++) {

                        data2[i] = data2[i].replace("{", "");

                        data2[i] = data2[i].replace("}", "");

                        const data3 = data2[i].split(",")

                        dockerImages += data3[1] + "\n"

                        containerId += data3[0] + "\n"

                    }

                    dockerImages = dockerImages.toString().replace(/"/g, '')

                    containerId = containerId.toString().replace(/"/g, "");

                    this.setState({ ...this.state, dockerImages: dockerImages, containerId: containerId })
                })
                .catch(error => console.error(error));

        }
    }
    render() {
        const value = "";

        return (
            <div>
                <div className="container" data-spy="scroll">
                    <h1>Docker Images</h1>
                    <div className="form-group">
                        <textarea className="form-control" id="exampleFormControlTextarea1" rows="10" value={this.state.dockerImages} disabled={true}>


                        </textarea>
                    </div>

                </div>
                <div className="container" data-spy="scroll">
                    <h1>Docker Container</h1>
                    <div className="form-group">
                        <textarea className="form-control" id="exampleFormControlTextarea1" rows="10" value={this.state.containerId} disabled={true}>


                        </textarea>
                    </div>

                </div>
            </div>

        )
    }
}
