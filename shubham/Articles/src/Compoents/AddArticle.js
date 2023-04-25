import React from "react";


const AddArticle = (props) => {


    return (
        <>
            <div>
                <div class="ui cards">
                    <div class="ui red fluid card">
                        <form class="ui form" onSubmit={(event) => {
                            console.log({ name: event.target.Name.value, title: event.target.Title.value, descripation: event.target.descripation.value });
                        }}>
                            <div class="field"><label>Name</label><input placeholder="Name" name="Name" /></div>
                            <div class="field"><label>Title</label><input placeholder="Title" name="Title" /></div>

                            <div class="field"><label>Description</label><textarea placeholder="Write the article.." rows="5" name="descripation"></textarea></div>
                            <button class="ui button" type="submit">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}
export default AddArticle;