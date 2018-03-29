import React from 'react';
import logo from '../../images/logo.png';
import './Header.css';

export class Header extends React.Component{



    constructor(){
        super()
        this.state ={
            
        }
    }
    componentDidMount(){
        fetch('https://randomuser.me/api/?results=500')
        .then(function(covertJson){
            return covertJson.json();
        })
        .then(data=>{
            let name =  data.results.map(function(value){                                
                return(
                    <p><span>{value.dob}</span>, <span>{value.name.first}</span></p>                    
                )                
            })
            this.setState({
                outPutVal: name[0]
            })

        })
    }

    render(){
        return(
            <header>                              
                <div className="logo">
                    <img src={logo} />
                </div>
               <div className="profile">
               <ul className="dropdown">
                        <li><a className="logout" href="#">Logout</a></li>
                    </ul>
                    <span className="name">Welcome back, {this.state.outPutVal}</span>
                    
               </div>

            </header>
        )
    }


}