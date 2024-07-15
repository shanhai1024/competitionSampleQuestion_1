import request from '@/utils/request'

// 查询参与投标表列表
export function listMark(query) {
  return request({
    url: '/procurementManagement/mark/list',
    method: 'get',
    params: query
  })
}

// 查询参与投标表详细
export function getMark(markId) {
  return request({
    url: '/procurementManagement/mark/' + markId,
    method: 'get'
  })
}

// 新增参与投标表
export function addMark(data) {
  return request({
    url: '/procurementManagement/mark',
    method: 'post',
    data: data
  })
}

// 修改参与投标表
export function updateMark(data) {
  return request({
    url: '/procurementManagement/mark',
    method: 'put',
    data: data
  })
}

// 删除参与投标表
export function delMark(markId) {
  return request({
    url: '/procurementManagement/mark/' + markId,
    method: 'delete'
  })
}

// 获取(平台动态,信息公告,政策法规)列表
export function getListByPage(params) {
  return request({
    url: '/procurement/getListByPage',
    method: 'get',
    params: params
  })
}

// 参与投标-报名
export function signUp(data) {
  return request({
    url: "/procurement/updMarkListById",
    method: "post",
    data: data,
  });
}
