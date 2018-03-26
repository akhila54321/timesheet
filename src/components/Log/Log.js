import React from 'react';
import './log.css';


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
            <form ref="resetFn" onSubmit={(e)=> {this.LogSubmitFn(e)}}>
                <table>
                <thead>
                        <tr>
                            <th>Date</th>
                            <th>Project</th>
                            <th>Task</th>
                            <th>Description</th>
                            <th>Time Log</th>
                            <th></th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr >
                            <td><input type="date" ref="date" placeholder="Date" /></td>
                            <td>
                                <select ref="project" width="200px">
                                    <option>Select</option>
                                    <option>Project 1</option>
                                    <option>Project 2</option>
                                </select>
                            </td>
                            <td> <input type="text" ref="task" placeholder="Task" /> </td>
                            <td><input type="text" ref="des" placeholder="Description" /></td>
                            <td><input type="text" ref="logs" placeholder="Time Log" /></td>
                            <td ref="demo"><button onClick={this.LogSubmitFn.bind(this)}>Save</button></td>                            
                        </tr>
                    
                    </tbody>
                </table>
                <h3>History</h3>
                <table>
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
                </table>                  
            </form>
        );
    }
}