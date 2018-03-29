import React from 'react';
import './Sidebar.css';


export class Sidebar extends React.Component{

    render(){
        return(
            <aside className="list sidebar">
                <ul>
                    <li>
                        <a href="#">Add Time Log</a>
                    </li>
                    <li>
                        <a href="#">View Timelog</a>
                    </li>
                </ul>
            </aside>
        );
    }
}