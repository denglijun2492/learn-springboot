import React,{Component} from 'react';
import {Form,Input,Modal} from 'antd';

const FormItem = Form.Item;

class ProductEditModal extends Component{
  constructor(props){
    super(props);
    this.state = {
      visible : false
    }
  }

  showHandler = (e) => {
    if (e) e.stopPropagation();
    this.setState({
      visible : true
    });
  };

  hideHandler = (e)=> {
    this.setState({
      visible : false
    });
  }

  okHandler = (e) => {
    const {onOk} = this.props;
    this.props.form.validateFields((err, values)=>{
      if(!err){
        onOk(values);
        this.hideHandler();
      }
    });
  }

  render(){
    const {children} = this.props;
    const { getFieldDecorator } = this.props.form;
    const {id, name, price, descr} = this.props.record;
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 14 },
    };

    return (
      <span>
        <span onClick={this.showHandler}>
          { children }
        </span>
        <Modal
          title="产品信息"
          visible={this.state.visible}
          onCancel={this.hideHandler}
          onOk={this.okHandler}
          okText='确定'
          cancelText='取消'
        >
          <Form layout="horizontal" onSubmit={this.okHandler}>
            <FormItem
              {...formItemLayout}
              label="ID"
            >
              {
                getFieldDecorator('id', {
                  initialValue: id,
                })(<Input />)
              }
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="名称"
            >
              {
                getFieldDecorator('name', {
                  initialValue: name,
                })(<Input />)
              }
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="价格"
            >
              {
                getFieldDecorator('price', {
                  initialValue: price,
                })(<Input />)
              }
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="描述信息"
            >
              {
                getFieldDecorator('descr', {
                  initialValue: descr,
                })(<Input />)
              }
            </FormItem>
          </Form>

        </Modal>
      </span>
    );
  }
}

export default Form.create()(ProductEditModal);
