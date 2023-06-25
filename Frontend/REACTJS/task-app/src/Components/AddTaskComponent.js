import React, { useState, useEffect} from 'react'
import {useNavigate, useParams } from 'react-router-dom';
import {createTasks, updateTasks, getTaskById} from '../Services/TaskService';
import 'bootstrap/dist/css/bootstrap.min.css';





const AddTaskComponent = () => {

    const [title, setTitle] = useState('')
    const [description, setDescription] = useState('')
    const [status, setStatus] = useState('')
    const [assignee, setAssignee] = useState('')

    const navigate = useNavigate();
    const {task_id} = useParams();

    const saveOrUpdateTasks = (e) => {
        e.preventDefault();

        const task = {title, description, status, assignee}

        console.log(task);
        if(task_id){
            updateTasks(task_id, task).then((response) => {
                navigate('/tasks')
            }).catch(error => {
                console.log(error)
            })

        }else{
            createTasks(task).then((response) =>{

                console.log(response.data)
    
                navigate('/tasks');
    
            }).catch(error => {
                console.log(error)
            })
        }
        
    }

    useEffect(() => {

        if(task_id){
            getTaskById(task_id).then((response) =>{
                setTitle(response.data.title)
                setDescription(response.data.description)
                setStatus(response.data.status)
                setAssignee(response.data.assignee)
            }).catch(error => {
                console.log(error)
            })
        }

    }, [task_id])



  return (
    <div>
        <div className='container'>
            <div className='row'>
                <div className='card'>
                    <h2 className='text-center'>Add Your Experience</h2>
                    <div className='card-body overflow-auto' style={{ maxHeight: '400px' }}>
                        <form>
                            <div className='form-group mb-2'>
                            <label className = "form-label"> Company Name :</label>
                                    <input
                                        type = "text"
                                        placeholder = "company name"
                                        name = "title"
                                        className = "form-control"
                                        value = {title}
                                        onChange = {(e) => setTitle(e.target.value)}
                                    >
                                    </input>
                            </div>
                            <div className='form-group mb-2'>
                            <label className = "form-label"> Position :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Position"
                                        name = "description"
                                        className = "form-control"
                                        value = {description}
                                        onChange = {(e) => setDescription(e.target.value)}
                                    >
                                    </input>
                            </div>
                            <div className='form-group mb-2'>
                            <label className = "form-label"> Interview Experience :</label>
                                    <input
                                        type = "text"
                                        placeholder = "experience"
                                        name = "status"
                                        className = "form-control"
                                        value = {status}
                                        onChange = {(e) => setStatus(e.target.value)}
                                    >
                                    </input>
                            </div>
                            <div className='form-group mb-2'>
                            <label className = "form-label"> Job Offered :</label>
                                    <input
                                        type = "text"
                                        placeholder = "Yes/No"
                                        name = "assignee"
                                        className = "form-control"
                                        value = {assignee}
                                        onChange = {(e) => setAssignee(e.target.value)}
                                    >
                                    </input>
                            </div>
                            <button className = "btn btn-success" onClick = {(e) => saveOrUpdateTasks(e)} >Submit </button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
      
    </div>
  )
}

export default AddTaskComponent 