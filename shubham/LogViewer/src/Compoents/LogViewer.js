import React, { useState } from "react";
import { isValidElement } from "react";

const LogViewer = () => {

    const [search, setSearch] = useState("");
    const [logData, setlogData] = useState("");
    const [filterData, setFilterData] = useState("");

    const fetchData = () => {
        const url = "http://localhost:8182/api/logs/" + search;
        fetch(url)
            .then(response => response.json())
            .then((data) => {
                let data1 = JSON.stringify(data);
                let data2 = data1.split('"logsSet":');
                let data3 = (data2[1]).split(",")


                setlogData(data3)
            })
            .catch(error => console.error(error));
    }
    const handleContainerLogView = () => {

        fetchData();


    }

    const handlePrint = () => {
        var divContents = document.getElementById("logContent").innerHTML;
        var a = window.open('', '', 'height=500, width=500');
        a.document.write('<html>');
        a.document.write('<body > <h6>Logs Viewer <br><br><br>');
        a.document.write(logData);
        a.document.write('</body></html>');
        a.document.close();
        a.print();
    }


    return (
        <>
            <div className="container my-3">
                <div className="row">
                    <div className="col">

                        <form>
                            <div className="form-group">
                                <input type="text" className="form-control" id="exampleInputEmail1" value={search} placeholder="Enter container ID" aria-describedby="emailHelp" onChange={(e) => {
                                    setSearch(e.target.value)
                                }} />
                            </div>
                        </form>

                    </div>
                    <div className="col">

                        <button type="submit" className="btn btn-primary" onClick={handleContainerLogView}>Submit</button>
                        <button type="submit" className="btn btn-primary mx-5" onClick={handlePrint}>print</button>
                    </div>

                </div>

                <div className="row">
                    <div className="container" data-spy="scroll">
                        <h1>Docker Error logs</h1>
                        <div className="form-group" id="logContent">
                            <textarea className="form-control" title="textArea1" disabled={true} value={logData} rows="16"></textarea>
                        </div>

                    </div>

                </div>
            </div>
        </>
    )

}

export default LogViewer;