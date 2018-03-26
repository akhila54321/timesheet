import React, {Component} from 'react';
import {Link,Redirect } from 'react-router-dom';
import './Login.css';

class Login extends Component{
	constructor(props){
		super(props);
		this.state= {
			email: '',
			password:''
		};
		this.handleLogin = this.handleLogin.bind(this);
	}
 	handleLogin(event){
 		event.preventDefault();
	   
	    if (this.state.email === '' || this.state.password =='') {
    	  return;
    	}

 		fetch('/login', {
  		method: 'POST',
  		headers: {
    		'Accept': 'application/json',
    		'Content-Type': 'application/json',
 		 },
 		 body: JSON.stringify({
   		 email: this.state.email,
    	password: this.state.password,
  		})
	}).then((response) => { console.log(response.status);
		if(response.status === 200){
			console.log("Login Successful");
			
		}else{
			console.log("status code:"+response.status);
		}
});

 	}
	render(){

		return(
	
			<div id="container" className="container">
			<form className="login-form">
				<h2 id="heading" className="btn btn-lg btn-primary btn-block">Plan View Login</h2>
				<input type="email" onChange={event =>this.setState({email:event.target.value})} className="form-control" id="inputemail" placeholder="Email Id" required autoFocus />
				<input type="password" onChange={event => this.setState({password:event.target.value})} className="form-control" id="inputpassword" placeholder="Password" required  />
				<div id="button-align">
				<input type="button" className="btn btn-lg btn-primary btn-block" onClick={(event) => {this.handleLogin(event)}} value="Login" />
				<Link to={'/Registration'}> sign up? </Link>
				
				</div>
			</form>
			</div>
		
			);
	}

}
export default Login;