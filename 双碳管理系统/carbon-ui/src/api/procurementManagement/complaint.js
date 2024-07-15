import request from '@/utils/request'

// 查询采购—投诉列表
export function listComplaint(query) {
  return request({
    url: '/procurementManagement/complaint/list',
    method: 'get',
    params: query
  })
}

// 查询采购—投诉详细
export function getComplaint(complaintId) {
  return request({
    url: '/procurementManagement/complaint/' + complaintId,
    method: 'get'
  })
}

// 新增采购—投诉
export function addComplaint(data) {
  return request({
    url: '/procurementManagement/complaint',
    method: 'post',
    data: data
  })
}

// 修改采购—投诉
export function updateComplaint(data) {
  return request({
    url: '/procurementManagement/complaint',
    method: 'put',
    data: data
  })
}

// 删除采购—投诉
export function delComplaint(complaintId) {
  return request({
    url: '/procurementManagement/complaint/' + complaintId,
    method: 'delete'
  })
}
