import PropTypes from 'prop-types'
import React, { Component } from 'react'

export default class NewsDetails extends Component {


    render() {
        return (
            <div className='container my-3'>
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe title={"sd"} className="embed-responsive-item" src="https://www.youtube.com/embed/v64KOxKVLVg" allowfullscreen={true}>
                        <h1>hello</h1>
                    </iframe>
                </div>
            </div>
        )
    }
}
