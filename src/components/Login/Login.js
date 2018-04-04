import React, {Component} from 'react';
import {Link,Redirect } from 'react-router-dom';
import logo from '../../images/logo.png';
import './Login.css';

class Login extends Component{
	constructor(props){
		super(props);
		this.state= {
			email: '',
			password:'',
			formErrors: {email: '', password: ''},
   			emailValid: false,
    		passwordValid: false,
    		formValid: false
		};
		this.handleLogin = this.handleLogin.bind(this);
	}
	validateInputField(event){
		event.preventDefault();
		const name = event.target.name;
		const value = event.target.value;
		this.setState({[name]: value}, 
                () => { this.validateField(name, value) });

	}
	validateField(fieldName, value) {
  		let fieldValidationErrors = this.state.formErrors;
  		let emailValid = this.state.emailValid;
 		 let passwordValid = this.state.passwordValid;

 		 switch(fieldName) {
    		case 'email':
     		 emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
      		 fieldValidationErrors.email = emailValid ? '' : ' is invalid, Must contain @ and .';
      		break;
   		 case 'password':
      		passwordValid = value.length >= 6;
       		fieldValidationErrors.password = passwordValid ? '': ' is too short';
      	 break;
   		 default:
       		break;
      	}
   			this.setState({formErrors: fieldValidationErrors,
                 	 emailValid: emailValid,
                 	 passwordValid: passwordValid
               		 }, this.validateForm);
	}

	validateForm() {
 		 this.setState({formValid: this.state.emailValid && this.state.passwordValid});
	}
 	handleLogin(event){
 		event.preventDefault();
	   
	    
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
					<form id="validation" method="POST" action=" " >
						<h2>Log your Effort</h2>
						<input type="email" className="form-control" onChange={event =>this.validateInputField(event)} placeholder="Email" name="email" required autoFocus />
						<div className="error-msg">{this.state.formErrors.email}</div>
						<input type="password" onChange={event => this.validateInputField(event)} className="form-control" placeholder="Password" name="password" required  />
						<div className="error-msg">{this.state.formErrors.password}</div>
						<div id="button-align">
						<button type="submit" className="btn" onClick={(event) => {this.handleLogin(event)}} disabled={!this.state.formValid} >Login</button>
						<Link className="btn text" to={'/Registration'}> If you are new member! <span>Register Here </span> </Link>
						
						</div>
					</form>
				</div>
			</div>
		
			);
	}

}
export default Login;