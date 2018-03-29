import React from 'react';
import './log.css';

import {Sidebar} from '../Sidebar/Sidebar';
import {Header} from '../Header/Header';


export class Log extends React.Component{
    constructor(){
        super();
        this.state = {
            rows: [''],
            arrayValues:[]
        }        
    }

    LogSubmitFn(e){
        e.preventDefault();
        let arrayVal = [];
        let proDate = this.refs.date.value;
        let project = this.refs.project.value;
        let description = this.refs.des.value;
        let task = this.refs.task.value;
        let logs = this.refs.logs.value;   

        fetch('/log',{
            method:'POST',
            headers: {            
                'Accept':'application/json',
            },
            body: JSON.stringify({
                'Date': proDate,
                'Project': project,
                'Description': description,
                'Task': task,
                'Time Log': logs

            })
        })
        arrayVal.push(proDate, project, task, description, logs);
        let arrayValues = this.state.arrayValues;                
        this.setState({
            arrayValues:[...arrayValues, arrayVal]
        }) 
        
        this.refs.resetFn.reset();
    }

    

    render(){
        return(
            <div>
                <Header />
            <div className = "container">
            <div class="col-4">
            <Sidebar />
            </div>
            

            <div class="col-12 margin25 logs">
            <form ref="resetFn" onSubmit={(e)=> {this.LogSubmitFn(e)}} >
            <h2>Add your efforts</h2>
            <ul class="log-effort">
                <li>
                    <label>Date</label>
                    <input className ="form-control" type="date" ref="date" placeholder="Date" />
                </li>

                <li>
                    <label>Project</label>
                    <select className ="form-control"  ref="project" width="200px">
                                    <option>Select</option>
                                    <option>Project 1</option>
                                    <option>Project 2</option>
                                </select>
                </li>

                <li>
                    <label>Task</label>
                    <input className ="form-control"  type="text" ref="task" placeholder="Task" />
                </li>

                 <li>
                    <label>Description</label>
                    <textarea className ="form-control"  type="text" ref="des" placeholder="Description" />
                </li>

                <li>
                    <label>Time Log</label>
                    <input className ="form-control"   type="text" ref="logs" placeholder="Time Log" />
                </li>

                <li>
                <button onClick={this.LogSubmitFn.bind(this)} className="btn">Save</button>
                </li>
            </ul>
                {/* <h3>History</h3> */}
                {/* <table>
                <thead>
                        <tr>
                            <th>Date</th>
                            <th>Project</th>
                            <th>Task</th>
                            <th>Description</th>
                            <th>Time Log</th>
                        </tr>
                    </thead>

                    <tbody> 
                    {this.state.arrayValues.map((value) => (                                           
                        <tr>                                                
                            <td key={value}>
                                {value}                                
                            </td>
                            <td>
                                <button>Edit</button>
                            </td>
                            <td>
                                <button>Delete</button>
                            </td>                            
                        </tr> 
                        ))}                          
                    </tbody>                       
                </table>                   */}
            </form>
            </div>

            
            </div>
            </div>
        );
    }
}