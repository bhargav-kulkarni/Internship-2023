import React, { Component } from 'react'

export default class NewsItem extends Component {

    handleViewData = () => {
    }
    render() {
        let { title, Descripation, ImageUrl, url, Auther, publishAt } = this.props; //destructuring 

        return (
            <div className='container my-3'>
                <div className="card">
                    <img src={ImageUrl ? ImageUrl : "https://img.ksl.com/slc/2922/292275/29227576.jpeg?filter=kslv2/responsive_story_lg"} className="card-img-top" alt="..." width={"287px"} height={"132px"} />
                    <div className="card-body">
                        <h5 className="card-title">{title.trim()}...</h5>
                        <p className="card-text">{Descripation.trim()}...</p>
                        <p class="card-text"><small class="text-muted">By {!Auther ? "Unkown" : Auther}</small></p>
                        <a href={url} target="_blank" className='btn btn-dark btn-sn' rel="noreferrer">Read more</a>
                    </div>
                </div>
            </div>
        )
    }
}
