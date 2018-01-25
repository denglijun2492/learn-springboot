import request from '../utils/request';

export function find({page}) {
  return request(`/api/product/find?pageNum=${page}&pageSize=3`);
}
