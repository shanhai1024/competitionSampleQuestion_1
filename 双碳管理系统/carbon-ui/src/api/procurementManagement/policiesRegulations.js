import request from '@/utils/request'

// 查询政策法规列表
export function listPoliciesRegulations(query) {
  return request({
    url: '/procurementManagement/PoliciesRegulations/list',
    method: 'get',
    params: query
  })
}

// 查询政策法规详细
export function getPoliciesRegulations(listId) {
  return request({
    url: '/procurementManagement/PoliciesRegulations/' + listId,
    method: 'get'
  })
}

// 新增政策法规
export function addPoliciesRegulations(data) {
  return request({
    url: '/procurementManagement/PoliciesRegulations',
    method: 'post',
    data: data
  })
}

// 修改政策法规
export function updatePoliciesRegulations(data) {
  return request({
    url: '/procurementManagement/PoliciesRegulations',
    method: 'put',
    data: data
  })
}

// 删除政策法规
export function delPoliciesRegulations(listId) {
  return request({
    url: '/procurementManagement/PoliciesRegulations/' + listId,
    method: 'delete'
  })
}
