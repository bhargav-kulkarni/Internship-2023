import React from "react";
import { Link } from "react-router-dom";
const ArticleCard = (props) => {
    const article = props.articleContent;
    return (
        <div class="ui cards">
            <div class="ui red fluid card">
                <div class="content">
                    <div class="description">
                        <Link key={article.name} className="article-list-item" to={"/article/" + article.name}>

                            <h3>{article.title}</h3>
                            <p>{article.content[0].substring(0, 150)}</p>

                        </Link>


                    </div>
                </div>
            </div>
        </div>
    )
}
export default ArticleCard;