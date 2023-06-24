import React, { useState, useEffect } from 'react'
import { listTasks, deleteTasks } from '../Services/TaskService'
import { useNavigate } from 'react-router-dom'
import '../ListTaskComponents.css'


const ListTaskCompoments = () => {

  const [tasks, setTasks] = useState([])
  const navigate = useNavigate()

  useEffect(() => {

    getAllTasks();

  }, [])

  const getAllTasks = () => {
    listTasks().then((response) => {
        setTasks(response.data)
        console.log(response.data);
    }).catch(error =>{
        console.log(error);
    })
}

const removeTasks = (taskId) => {
    deleteTasks(taskId).then((response) =>{
     getAllTasks();

    }).catch(error =>{
        console.log(error);
    })
     
}


  function addNewTask() {
    navigate('/add-task')
}

   const updateTasks = (task_id) => {
    navigate(`/edit-task/${task_id}`)
    }
  
  return (
    <div className='container'>
        <h2 className='text-center'>Tasks List</h2>
        <button className = "btn btn-primary mb-2" onClick={addNewTask}>Add new task</button>
        <table className='table table-bordered table-striped'>
            <thead>
                <th> Task ID </th>
                <th> Title </th>
                <th> Description </th>
                <th> Status </th>
                <th> Assigned to </th>
                <th>Actions</th>
            </thead>
            <tbody>
                {
                    tasks.map(
                        task =>
                        <tr key = {task.id}>
                        <td>{task.task_id}</td>    
                        <td>{task.title}</td>
                        <td>{task.description}</td>
                        <td>{task.status}</td>
                        <td>{task.assignee}</td>
                        <td>
                        <button className="btn btn-info" onClick={() => updateTasks(task.task_id)} >Update</button>
                        <button className = "btn btn-danger" onClick = {() => removeTasks(task.task_id)}
                        style = {{marginLeft:"10px"}}> Delete</button>
                        </td>
                        
                        </tr>
                    )
                }
            </tbody>

        </table>
        
    </div>
  )
}

export default ListTaskCompoments