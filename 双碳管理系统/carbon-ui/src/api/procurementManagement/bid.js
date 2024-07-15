import request from '@/utils/request'

// 查询我的投标列表
export function listBid(query) {
  return request({
    url: '/procurementManagement/bid/list',
    method: 'get',
    params: query
  })
}

// 查询我的投标详细
export function getBid(id) {
  return request({
    url: '/procurementManagement/bid/' + id,
    method: 'get'
  })
}

// 新增我的投标
export function addBid(data) {
  return request({
    url: '/procurementManagement/bid',
    method: 'post',
    data: data
  })
}

// 修改我的投标
export function updateBid(data) {
  return request({
    url: '/procurementManagement/bid',
    method: 'put',
    data: data
  })
}

// 删除我的投标
export function delBid(id) {
  return request({
    url: '/procurementManagement/bid/' + id,
    method: 'delete'
  })
}

// 标列表
export function getMarkList(params) {
  return request({
    url: "/procurement/getMarkList",
    method: "get",
    params: params,
  });
}

// 我的投标-详情
export function getHaveBidById(params) {
  return request({
    url: "/procurement/getHaveBidById",
    method: "get",
    params: params,
  });
}

// 我的投标-提交资料
export function setHaveBidList(data) {
  return request({
    url: "/procurement/setHaveBidList",
    method: "post",
    params: data,
  });
}

