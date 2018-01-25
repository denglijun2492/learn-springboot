import React from 'react';
import {Menu, Icon} from 'antd';
import {Link} from 'dva/router';

function Header({location}) {
  return (
    <Menu
      selectedKeys={[location.pathname]}
      mode="horizontal"
      theme="dark"
    >
      <Menu.Item key="/products">
        <Link to="/products">产品列表</Link>
      </Menu.Item>
      <Menu.Item key="/">
        <Link to="/">首页</Link>
      </Menu.Item>
    </Menu>
  );
}

export default Header;
