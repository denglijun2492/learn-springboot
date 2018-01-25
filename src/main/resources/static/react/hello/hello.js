var a = 1, b=4;
var s = '我是字符';
var myStyle = {
    color : 'red',
    fontSize : 15
};
//数组
var arr =[
    <div>123</div>,
    <div>456</div>,
    <div>789</div>
]
ReactDOM.render(
    /*根目录必须只有一个标签节点*/
    <div>
        <h1>hello react!</h1>
        <h3>打印计算表达式：{a + b}</h3>
        <h3 style={myStyle}>打印计算表达式：{'【'+ s +'】'}</h3>
        <h3>打印三元表达式：{2>1 ? '大于' : '小于'}</h3>
        <h3>{/*我是注释*/}</h3>
        <div>{arr}</div>
    </div>,
    document.getElementById('example')
);