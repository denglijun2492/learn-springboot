function HelloMessage(props){
        return <h1>hello {props.name}!</h1>;
}

function HelloList() {
    return (
        <div>
            <HelloMessage name="1"/>
            <HelloMessage name="2"/>
            <HelloMessage name="3"/>
            <HelloMessage name="4"/>
        </div>
    );
}

function Avatar(props) {
    return (
        <img src={props.user.url} alt={props.user.name}/>
    );
}

function UserInfo(props) {
    return(
      <div>
          <Avatar user={props.user}/>
          <div>{props.user.name}</div>
      </div>
    );
}

function Comment(props) {
    return(
      <div style={props.style}>
          <UserInfo user={props.author}/>
          <div>{props.text}</div>
          <div>{props.date}</div>
      </div>
    );
}

var comment = {
    text : "我是评论...",
    date : "2018-1-1",
    author : {
        url : "http://www.baidu.com",
        name : "邓礼俊"
    },
    style : {
        backgroundColor : "gray",
        fontSize : 20
    }
}

class HelloMessage2 extends React.Component{
  render(){
      return <h1>hello {this.props.name}</h1>;
  }
};

ReactDOM.render(
    <div>
        <HelloMessage name="denglj"/>
        <HelloMessage2 name="react"/>
        <HelloList/>
        <Comment text={comment.text} date={comment.date} author={comment.author}/>
    </div>,
    document.getElementById("example")
);