import MainLayout from '../components/MainLayout/MainLayout';
import {connect} from 'dva';
import {routerRedux} from 'dva/router';
import {Table,Pagination, Popconfirm, Button} from 'antd';
import queryString from 'query-string';
import ProductModal from '../components/Product/ProductModal';
import styles from './Product.css';

function Products({dispatch, location, list : dataSource, page : current, total}) {
  function pageChangeHandler(page) {
    dispatch(routerRedux.push({
      pathname : "/products",
      search : queryString.stringify({ page })
    }));
  }
  function createHandler(values) {
    dispatch({
      type : "products/create",
      payload : values
    });
  }
  function editHandler(id, values) {
    dispatch({
      type: "products/update",
      payload : {id, values}
    });
  }
  function deleteHandler(id) {
    dispatch({
      type: "products/remove",
      payload : id
    });
  }

  const Columns = [{
    title : 'ID',
    dataIndex : 'id',
    key : 'id'
  },{
    title : '名称',
    dataIndex : 'name',
    key : 'name'
  },{
    title : '价格',
    dataIndex : 'price',
    key : 'price'
  },{
    title : '描述',
    dataIndex : 'descr',
    key : 'descr'
  },{
    title : "操作",
    key : "operation",
    render : (text, record) => (
      <span className={styles.operation}>
        <ProductModal record={record} onOk={editHandler.bind(null, record.id)}>
          <a>修改</a>
        </ProductModal>
        <Popconfirm title="是否删除？" onConfirm={deleteHandler.bind(null, record.id)}>
          <a>删除</a>
        </Popconfirm>
      </span>
    )
  }];
  return (
    <MainLayout location={location}>
      <div className={styles.normal}>
        <div>
          <ProductModal record={{}} onOk={createHandler}>
            <Button type="primary">新增</Button>
          </ProductModal>
        </div>
        <div>
          <Table
            columns={Columns}
            dataSource={dataSource}
            pagination={false}
          />
          <Pagination
            total={total}
            current={current}
            pageSize={3}
            onChange={pageChangeHandler}
            className="ant-table-pagination"
          />
        </div>

      </div>
    </MainLayout>
  );
}

function mapStateToProps(state) {
  const {list, total, page} = state.products;
  return {
    list,
    total,
    page
  };
}
export default connect(mapStateToProps)(Products);
