
import './App.css';
import About from './Compoents/About';
import Article from './Compoents/Article';
import Home from './Compoents/Home';
import { Routes, Route, BrowserRouter } from "react-router-dom"
import NavBar from './Compoents/NavBar';
import ArticlePages from './Compoents/ArticlePages';
import NotFound from './Compoents/NotFound';


function App() {

  return (
    <BrowserRouter>
      <div className="App">

        <NavBar />
        <div id="page-body">
          <Routes>
            <Route path="/" element={<Home />}></Route>
            <Route path="/about" element={<About />}></Route>
            <Route path="/article" element={<Article />}></Route>
            <Route path="/article/:articleId" element={<ArticlePages />}></Route>
            <Route path="*" element={<NotFound />} />
          </Routes>
        </div>
      </div>
    </BrowserRouter >
  );
}

export default App;
