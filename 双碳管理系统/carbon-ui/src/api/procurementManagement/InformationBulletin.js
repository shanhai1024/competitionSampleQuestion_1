import request from '@/utils/request'

// 查询信息公告列表
export function listInformationBulletin(query) {
  return request({
    url: '/procurementManagement/InformationBulletin/list',
    method: 'get',
    params: query
  })
}

// 查询信息公告详细
export function getInformationBulletin(listId) {
  return request({
    url: '/procurementManagement/InformationBulletin/' + listId,
    method: 'get'
  })
}

// 新增信息公告
export function addInformationBulletin(data) {
  return request({
    url: '/procurementManagement/InformationBulletin',
    method: 'post',
    data: data
  })
}

// 修改信息公告
export function updateInformationBulletin(data) {
  return request({
    url: '/procurementManagement/InformationBulletin',
    method: 'put',
    data: data
  })
}

// 删除信息公告
export function delInformationBulletin(listId) {
  return request({
    url: '/procurementManagement/InformationBulletin/' + listId,
    method: 'delete'
  })
}
