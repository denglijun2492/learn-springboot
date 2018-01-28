import queryString from 'query-string';
import * as productService from '../services/product';

export default {
  namespace : "products",
  state : {
    list : [],
    total : null,
    page : null
  },
  reducers : {
    save(state, {payload : {list, total, page}}){
      console.log(list);
      return {...state, list, total, page};
    }
  },
  effects : {
    *find({payload:{page=1}}, {call, put}){
      const {data} = yield call(productService.find, {page});
      yield put({
        type : 'save',
        payload : {
          list : data.list,
          total : data.total,
          page : data.pageNum
        }
      });
    },
    *create({ payload: values }, { call, put }) {
      yield call(productService.create, values);
      yield put({ type: 'reload' });
    },
    *update({ payload: {id, values} }, { call, put }) {
      yield call(productService.update, id, values);
      yield put({ type: 'reload' });
    },
    *remove({ payload: id }, { call, put }) {
      yield call(productService.remove, id);
      yield put({ type: 'reload' });
    },
    *reload(action, { put, select }) {
      const page = yield select(state => state.products.page);
      yield put({ type: 'find', payload: { page } });
    },
  },
  subscriptions : {
    setup({dispatch, history}){
      return history.listen(({pathname, search}) => {
        const query = queryString.parse(search);
        if(pathname === '/products'){
          dispatch({type:"find", payload : query});
        }
      });
    }
  }
}
