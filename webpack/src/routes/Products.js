import MainLayout from '../components/MainLayout/MainLayout';
import {connect} from 'dva';
import {routerRedux} from 'dva/router';
import {Table,Pagination, Popconfirm, Button} from 'antd';
import queryString from 'query-string';

function Products({dispatch, location, list : dataSource, page : current, total}) {
  function pageChangeHandler(page) {
    dispatch(routerRedux.push({
      pathname : "/products",
      search : queryString.stringify({ page })
    }));
  }
  const Columns = [{
    title : 'ID',
    dataIndex : 'id',
    key : 'id'
  },{
    title : '名称',
    dataIndex : 'name',
    key : 'name'
  }];
  return (
    <MainLayout location={location}>
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
