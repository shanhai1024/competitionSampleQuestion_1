import request from '@/utils/request'

// 查询平台动态列表
export function listPlatformDynamics(query) {
  return request({
    url: '/procurementManagement/platformDynamics/list',
    method: 'get',
    params: query
  })
}

// 查询平台动态详细
export function getPlatformDynamics(listId) {
  return request({
    url: '/procurementManagement/platformDynamics/' + listId,
    method: 'get'
  })
}

// 新增平台动态
export function addPlatformDynamics(data) {
  return request({
    url: '/procurementManagement/platformDynamics',
    method: 'post',
    data: data
  })
}

// 修改平台动态
export function updatePlatformDynamics(data) {
  return request({
    url: '/procurementManagement/platformDynamics',
    method: 'put',
    data: data
  })
}

// 删除平台动态
export function delPlatformDynamics(listId) {
  return request({
    url: '/procurementManagement/platformDynamics/' + listId,
    method: 'delete'
  })
}
