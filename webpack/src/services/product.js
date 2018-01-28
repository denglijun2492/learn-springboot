import request from '../utils/request';

export function find({page}) {
  return request(`/api/product?pageNum=${page}&pageSize=3`);
}

export function remove(id) {
  return request(`/api/product/${id}`, {
    method : 'DELETE'
  });
}

export function create(values) {
  return request(`/api/product`, {
    body: JSON.stringify(values),
    method: 'POST',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    },
  });
}

export function update(id, values) {
  return request(`/api/product/${id}`, {
    body: JSON.stringify(values),
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json;charset=UTF-8'
    },
  });
}
