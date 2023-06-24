import axios from 'axios';

const TASK_API_URL = 'http://localhost:8080/api/v1/tasks';

export const listTasks = () => {
        return axios.get(TASK_API_URL);
    };
export const createTasks = (task) => {
        return axios.post(TASK_API_URL, task)
    }
export const updateTasks = (task_id, task) => {
        return axios.put(TASK_API_URL + '/' +task_id, task);
    }
export const getTaskById = (task_id) => {
        return axios.get(TASK_API_URL + '/' + task_id);
    }
export const deleteTasks = (task_id) => {
        return axios.delete(TASK_API_URL + '/' + task_id);
    }


