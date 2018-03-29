import React from 'react';
import './log.css';
import {Sidebar} from '../Sidebar/Sidebar';
import {Header} from '../Header/Header';import './log.css';
export class LogDetail extends React.Component{

    constructor(){
        super();
        this.state ={
            data:[],
            arrayValue:['']
              
        }
    }

    componentDidMount(){
        fetch('https://randomuser.me/api/?results=5')
    .then((Response)=>Response.json())
    .then((findresponse)=>{
      this.setState({data:findresponse.results});
      console.log(this.state.data);
      })
    }

    handleEdit(index,e){
      e.preventDefault();
      var t=document.getElementsByClassName('form-control ' + index);
      for(let i=0;i<t.length;i++){
      t[i].disabled = false;
      } 
      let btn = document.getElementsByClassName('btn text '+index);
      let btncancel = document.getElementsByClassName('btn text cancel'+index);
      if(btn[0].value === "Edit"){
        btn[0].value= "save";
        btn[0].disabled = true;
        btncancel[0].value="cancel";
      }else{
         fetch('/edit',{
              method:'POST',
              headers: {            
              'Accept':'application/json',
            },
            body: JSON.stringify({
               'id':index,
                'Project':t[0].value,
                'Date': t[1].value,
                'Description': t[2].value,
                'TicketID': t[3].value,
                'Time': t[4].value
                

            })
        }).then((response) => { console.log(response.status);
        if(response.status === 404){
           let newdata ={
            "gender": t[0].value,
            "Date" :t[1].value,
            "email":t[2].value,
            "TicketID":t[3].value,
            "Time": t[4].value
           };
            let newrow = this.state.data.slice(0,index);
            newrow.push(newdata);
            newrow = newrow.concat(this.state.data.slice(index+1));
            this.setState({data:newrow});
            alert("Update Successfull");
        }else{
            alert("status code:"+response.status);
           }
         });
        for(let i=0;i<t.length;i++){
          t[i].disabled = true;
        } 
        btn[0].value="Edit";
      }
    }
    handleDelete(index,e){
      e.preventDefault();
      let btncancel = document.getElementsByClassName('btn text cancel'+index);
      if(btncancel[0].value==="cancel"){
           
      }
      let url='https://randomuser.me/api/?results='+index;
      alert(url);
      fetch(url,{
            method:'DELETE',
            }).then((response) => { console.log(response.status);
           if(response.status === 200){
              alert("Delete Successful");
           }else{
            alert("status code:"+response.status);
           }
         });
            alert(index);
            let newRows = this.state.data.slice(0,index);
            newRows= newRows.concat(this.state.data.slice(index+1));
            this.setState({data:newRows});
        
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
              <form ref="resetFn">
            <table id="userlist">
             <thead>
              <tr>
                <th>Project</th>
                <th>Date</th>
                <th>Description</th>
                <th>TicketID</th>  
                <th>Time(in hours)</th>
              </tr>
             </thead>
            
            <tbody>
                { console.log(this.state.data),
                  this.state.data.map((details,index)=>
                    <tr key={details.email}>
                      <td><input className={'form-control ' + index} type="text" defaultValue={details.gender} disabled required/></td>
                      <td><input className={'form-control ' + index} type="date" name="Date" defaultValue={details.Date}disabled /></td> 
                      <td><input className={'form-control ' + index} type="text" name="Description" defaultValue={details.email} disabled /></td> 
                      <td><input className={'form-control ' + index} type="text" name="TicketID" defaultValue={details.registered} disabled /></td> 
                      <td><input className={'form-control ' + index} type="text" name="Time" defaultValue={details.phone} disabled/></td> 
                      <td><input className={'btn text '+index} type="submit" onClick={(event)=>this.handleEdit(index,event)} value="Edit"/></td>
                      <td><input type="button" className={'btn text cancel'+index} onClick={(event)=>this.handleDelete(index,event)} value="Delete"/></td>
                    </tr>
                )}
            </tbody>           
          </table>
        </form>  
            </div>

            
            </div>
            </div>

        )

    }

}