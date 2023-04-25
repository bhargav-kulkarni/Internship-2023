import React from "react";
import { useParams } from "react-router";
import articles from "./article-content";
import NotFound from "./NotFound";

const ArticlePages = () => {
    const { articleId } = useParams();
    const article = articles.find(article => article.name === articleId);
    if (!article)
        return <NotFound />
    return (
        <>

            <h1>{article.title}</h1>
            {article.content.map((pargraph, i) => (
                <p key={i}>{pargraph}</p>
            ))}

        </>

    )
}
export default ArticlePages;