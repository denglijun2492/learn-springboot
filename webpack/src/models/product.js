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
    }
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
