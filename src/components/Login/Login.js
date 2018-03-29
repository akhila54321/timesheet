import React, {Component} from 'react';
import {Link,Redirect } from 'react-router-dom';
import logo from '../../images/logo.png';
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
	
			<div id="container" className="container wrap-login">
				<div className="login-form box-1">
				<div className="wrap-logo">
				<img src={logo} className="logo" />
				</div>
					<form >
						<h2>Log your Effort</h2>
						<input type="email"  className="form-control" id="inputemail" placeholder="Email Id" required autoFocus />
						<input type="password" onChange={event => this.setState({password:event.target.value})} className="form-control" id="inputpassword" placeholder="Password" required  />
						<div id="button-align">
						<input type="button" className="btn" onClick={(event) => {this.handleLogin(event)}} value="Login" />
						<Link className="btn text" to={'/Registration'}> If you are new member! <span>Register Here </span> </Link>
						
						</div>
					</form>
				</div>
			</div>
		
			);
	}

}
export default Login;