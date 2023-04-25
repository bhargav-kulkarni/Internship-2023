import React, { Component } from 'react'
import NewsItem from './NewsItem'
import PropTypes from 'prop-types';
const jsonApikey = {
    "status": "error", "code": "rateLimited", "message": "You have made too many requests recently. Developer accounts are limited to 100 requests over a 24 hour period (50 requests available every 12 hours). Please upgrade to a paid plan if you need more requests."
}
// const apiArray = ["2b0cb0c17b554a049f5ac421deb546ff", "33ea77d5d9244c5d94e73857c1e9f6b8", "f423e478b30f49deb13efa007371d924", "c90e7dd5c81342cbbc6baed260268269", "ff6af5131a344334bf7938896f5b27af", "aa604a6081a34017b4142832a0fce9d9", "3ce5e27ee1c645d8bb1c84968eae5e6e", "49c654a4be4f4782bbf69168acb3972c", "f423e478b30f49deb13efa007371d924"]
const apiArray = ["24d7f2199ad046c08cafd5ab9d5fe68b", "00a36490f57a40f3bccac8464b1dfc3b", "ec4f24458b4f46f2b069fe0a44daa9b4", "5f3ba34b281f496ca1e58ec8bf70c6fa", "2b0cb0c17b554a049f5ac421deb546ff"]

export default class NewsCompoent extends Component {
    static defaultProps = {
        country: 'in',
        category: 'general'
    };

    static propTypes = {
        country: PropTypes.string,
        category: PropTypes.string
    };


    constructor(props) {
        super(props);
        this.state = {
            article: [],
            page: 1,
            nextPage: 2
        }
    }
    async componentDidMount() {
        // let i;
        // for (i = 0; i < apiArray.length; i++) {
        //     let url = "https://newsapi.org/v2/everything?q=tesla&from=2023-03-02&sortBy=publishedAt&apiKey=" + apiArray[i];
        //     let data = await fetch(url);
        //     let jsonData = await data.json();
        //     if (JSON.stringify(jsonData) !== JSON.stringify(jsonApikey)) {
        //         this.setState({ ...this.state, article: jsonData.articles })
        //         break;
        //     }
        // }

        // if (i === apiArray.length && this.state.article.length === 0) {
        //     alert("No more request for today.All api key expired")
        // }

        let country = this.props.country;
        let category = this.props.category;

        console.log("country" + this.props.country)
        console.log("category" + this.props.category)

        let url = `https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiArray[0]}`
        let data = await fetch(url);
        let jsonData = await data.json();
        console.log("jsonData" + jsonData)
        this.setState({ ...this.state, article: jsonData.articles })

    }

    // async componentDidUpdate() {
    //     // let i;
    //     // for (i = 0; i < apiArray.length; i++) {
    //     //     let url = "https://newsapi.org/v2/everything?q=tesla&from=2023-03-02&sortBy=publishedAt&apiKey=" + apiArray[i] + "&page=" + this.state.page;
    //     //     let url1 = "https://newsapi.org/v2/everything?q=tesla&from=2023-03-02&sortBy=publishedAt&apiKey=" + apiArray[i] + "&page=" + this.state.page + 1;

    //     //     let data = await fetch(url);
    //     //     let data1 = await fetch(url1);
    //     //     let jsonData = await data.json();

    //     //     let jsonData1 = await data1.json();
    //     //     if (JSON.stringify(jsonData) !== JSON.stringify(jsonApikey) && (JSON.stringify(jsonData1) === JSON.stringify(jsonApikey) || JSON.stringify(jsonData1) === JSON.stringify(""))) {
    //     //         this.setState({ ...this.state, article: jsonData.articles, nextPage: this.state.nextPage })
    //     //         break;
    //     //     }
    //     //     if (JSON.stringify(jsonData) !== JSON.stringify(jsonApikey)) {
    //     //         this.setState({ ...this.state, article: jsonData.articles, nextPage: this.state.nextPage + 1 })
    //     //         break;
    //     //     }
    //     // }
    //     // if (i === this.state.apiArray.length && this.state.article.length === 0) {
    //     //     alert("No more request for today.All api key expired")
    //     // }


    //     let url = "https://newsapi.org/v2/everything?q=tesla&from=2023-03-02&sortBy=publishedAt&apiKey=" + apiArray[0];
    //     let data = await fetch(url);
    //     let jsonData = await data.json();
    //     this.setState({ ...this.state, article: jsonData.articles })
    // } 
    // async UNSAFE_componentWillReceiveProps(nextprops) {

    //     if (this.props.category !== nextprops.category) {
    //         let country = nextprops.country;
    //         let category = nextprops.category;

    //         console.log("country" + this.props.country)
    //         console.log("category" + this.props.category)

    //         let url = `https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiArray[0]}`
    //         let data = await fetch(url);
    //         let jsonData = await data.json();
    //         console.log("jsonData" + jsonData)
    //         this.setState({ article: jsonData.articles })
    //     }
    // }


    

    async UNSAFE_componentWillUpdate() {
        let country = this.props.country;
        let category = this.props.category;

        console.log("country" + this.props.country)
        console.log("category" + this.props.category)

        let url = `https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiArray[0]}`
        let data = await fetch(url);
        let jsonData = await data.json();
        console.log("jsonData" + jsonData)
        this.setState({ ...this.state, article: jsonData.articles })

    }
    async componentWillUpdate() {


    }


    render() {
        return (
            <div className='container my-3'>
                <h1 className='text-center'>News Top headlines</h1>
                <div className="row">

                    {
                        this.state.article?.map((article) => {

                            return (
                                <div className="col-md-4" key={article.url}>

                                    <NewsItem title={article.title ? article.title.slice(0, 45) : ""} Descripation={article.description ? article.description.slice(0, 85) : ""} ImageUrl={article.urlToImage} url={article.url} Auther={article.author} publishedAt={article.publishedAt} />
                                </div>

                            )

                        })

                    }


                </div>
                <div className="container d-flex justify-content-between">
                    <button type="button" disabled={this.state.page <= 1} className="btn btn-dark" onClick={() => {
                        let page = this.state.page;
                        this.setState({ ...this.state, page: page - 1 })

                    }}>Previous</button>
                    <button type="button" disabled={this.state.page > this.state.nextPage} className="btn btn-dark" onClick={() => {
                        let page = this.state.page;
                        this.setState({ ...this.state, page: page + 1 })

                    }}>Next</button>
                </div>
            </div>
        )
    }
}

