import React, { Component } from 'react';
import './Registration.css';
import sideImg from '../../images/register.jpeg';
import {Link,Redirect } from 'react-router-dom';



class Registration extends Component {
  constructor(props){
    super(props);    
    this.handleClick = this.handleClick.bind(this);    
    this.state = { 
          
      redirect: false      
    }
  } 

  
handleClick(event) {
  
  let pass1 = this.refs.pswd1.value;
  let pass2 = this.refs.pswd2.value;
  
  if(pass1 !== pass2) {
    alert('passwords incorrect');
    return false;
  } 
  if(pass1 !== 0){
    return false;
  }
  

    return fetch('/register', {
    method: 'POST',
    
    headers: {
        'Content-Type': 'application/json',
         'Accept':'application/json',
    },
    body: JSON.stringify({
       name:this.state.name,
       empId: this.state.empId,
      email:this.state.email,
      password:this.state.password,
     
    }),
}).then((response) => {    
    if(response.status === 404){
      console.log("Registration Successful");
      this.state.redirect = true;

      
    }else{
      console.log("status code:"+response.status);
    }

});
  
}

  render() {
    const {redirect} = this.state;
    if(redirect){
      <Redirect to='/' />
    }

    return (
      <div className="container wrap-registration">
      <div className='thumb-register'>
        <img src={sideImg} />
      </div>
      <div className="registration box-1">
        <h2>Register here</h2>
        <p className="info">All the fields are mandatory for fill</p>
         <form id="validation" method="POST" action=" ">
        <input className="form-control" type="text" placeholder="Name" onChange={event => this.setState({name: event.target.value})} name="name1" ref="name2" required pattern="^(?:(?![ ]{2,}).)([A-Za-z]*\s+[A-Za-z]*)|([A-Za-z]*\s+[A-Za-z]*\s+[A-Za-z]*)|([A-Za-z]*)+$"/>
        <p className="form-info">*name with(no special charcters and numbers)</p>
        <input className="form-control" type="text" placeholder="EmployeeID" onChange={event => this.setState({empId: event.target.value})} required pattern="[a-zA-Z0-9-]+$" name="employeeId" ref="empid"/>
        <p className="form-info">*only letters and numbers</p>
        <input className="form-control" type="email" placeholder="Email" onChange={event => this.setState({email: event.target.value})} required name="emailId"/>
        <input className="form-control" type="password" ref="pswd1" placeholder="password" onChange={event => this.setState({password: event.target.value})} required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd1"/>
        <p class="form-info">*Atleast 6 letter word with(numbers,uppercase-lowercase alphabets and symbols).</p>
        <input className="form-control" type="password" ref="pswd2" placeholder="confirm password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"/>
        <button className="btn full-width" ref="submitForm" onClick={(event) => {this.handleClick(event)}}>Submit</button>
        <Link className="btn text" to={'/'}> Already a Member <span>Login Here </span> </Link>

      </form>
      </div>
      </div>
    )
  }
}

export default Registration;
