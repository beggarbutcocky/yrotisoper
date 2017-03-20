

var my_news = [
    {
        author: 'Kevin',
        title: 'some news'
    },
    {
        author: 'Hoking',
        title: 'I`m going to space'
    }
];


var News = React.createClass({
    render: function(){
        return(
            <div className="news">Новостей нет</div>
        )
    }
});

var Comments = React.createClass({
    render: function(){
        return(
            <div className="comments">Нет новостей, нечего комментировать</div>
        )
    }
})

var App = React.createClass({
    render: function(){
        return(
            <div className="app">
                Отображение новостей.
                <News data = {my_news}/>
                <Comments/>
            </div>
        )
    }
});


ReactDOM.render(<App/>, document.getElementById('root'));