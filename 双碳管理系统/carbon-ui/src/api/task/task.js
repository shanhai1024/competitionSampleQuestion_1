import request from '@/utils/request'

// 查询作业装配列表
export function listTask(query) {
  return request({
    url: '/task/task/list',
    method: 'get',
    params: query
  })
}

// 查询作业装配详细
export function getTask(id) {
  return request({
    url: '/task/task/' + id,
    method: 'get'
  })
}

// 新增作业装配
export function addTask(data) {
  return request({
    url: '/task/task',
    method: 'post',
    data: data
  })
}

// 修改作业装配
export function updateTask(data) {
  return request({
    url: '/task/task',
    method: 'put',
    data: data
  })
}

// 删除作业装配
export function delTask(id) {
  return request({
    url: '/task/task/' + id,
    method: 'delete'
  })
}
