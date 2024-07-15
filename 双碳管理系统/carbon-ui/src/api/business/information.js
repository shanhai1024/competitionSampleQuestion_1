import request from '@/utils/request'

// 查询设备信息管理列表
export function listInformation(query) {
  return request({
    url: '/business/information/list',
    method: 'get',
    params: query
  })
}

// 查询设备信息管理详细
export function getInformation(id) {
  return request({
    url: '/business/information/' + id,
    method: 'get'
  })
}

// 新增设备信息管理
export function addInformation(data) {
  return request({
    url: '/business/information',
    method: 'post',
    data: data
  })
}

// 修改设备信息管理
export function updateInformation(data) {
  return request({
    url: '/business/information',
    method: 'put',
    data: data
  })
}

// 删除设备信息管理
export function delInformation(id) {
  return request({
    url: '/business/information/' + id,
    method: 'delete'
  })
}
