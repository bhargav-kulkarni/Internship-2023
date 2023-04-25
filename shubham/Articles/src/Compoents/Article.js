import React from "react";
import { Link } from "react-router-dom";
import "../App.css";


import articles from "./article-content";
import ArticleCard from "./ArticleCard";
import Popup from "reactjs-popup";
import AddArticle from "./AddArticle";

const Article = () => {

    return (
        <>

            {
                articles.map(
                    article => (
                        <div>

                            <ArticleCard articleContent={article}></ArticleCard>
                        </div>
                    )
                )
            }
            <AddArticle />
        </>
    )

}
export default Article;