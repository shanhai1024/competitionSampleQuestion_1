import request from '@/utils/request'

// 查询采购—企业信息列表
export function listEnterpriseInformation(query) {
  return request({
    url: '/procurementManagement/enterpriseInformation/list',
    method: 'get',
    params: query
  })
}

// 查询采购—企业信息详细
export function getEnterpriseInformation(id) {
  return request({
    url: '/procurementManagement/enterpriseInformation/' + id,
    method: 'get'
  })
}

// 新增采购—企业信息
export function addEnterpriseInformation(data) {
  return request({
    url: '/procurementManagement/enterpriseInformation',
    method: 'post',
    data: data
  })
}

// 修改采购—企业信息
export function updateEnterpriseInformation(data) {
  return request({
    url: '/procurementManagement/enterpriseInformation',
    method: 'put',
    data: data
  })
}

// 删除采购—企业信息
export function delEnterpriseInformation(id) {
  return request({
    url: '/procurementManagement/enterpriseInformation/' + id,
    method: 'delete'
  })
}
