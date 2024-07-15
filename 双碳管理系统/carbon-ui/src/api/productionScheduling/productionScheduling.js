import request from '@/utils/request'

// 查询计划排产列表
export function listProductionScheduling(query) {
  return request({
    url: '/productionScheduling/productionScheduling/list',
    method: 'get',
    params: query
  })
}

// 查询计划排产详细
export function getProductionScheduling(id) {
  return request({
    url: '/productionScheduling/productionScheduling/' + id,
    method: 'get'
  })
}

// 新增计划排产
export function addProductionScheduling(data) {
  return request({
    url: '/productionScheduling/productionScheduling',
    method: 'post',
    data: data
  })
}

// 修改计划排产
export function updateProductionScheduling(data) {
  return request({
    url: '/productionScheduling/productionScheduling',
    method: 'put',
    data: data
  })
}

// 删除计划排产
export function delProductionScheduling(id) {
  return request({
    url: '/productionScheduling/productionScheduling/' + id,
    method: 'delete'
  })
}
