import React from 'react';
import {render} from 'react-dom';
import './index.css';
import Registration from './components/Registration/Registration';
import Login from './components/Login/Login';
import Log from './components/Log/Log';

import { BrowserRouter, Route} from 'react-router-dom';

render((<BrowserRouter>
	<div className="app">
      
      <Route exact path ='/' component={Login}/>
      <Route exact path ='/registration' component={Registration}/>
      <Route exact path ='/log' component={Log}/>
      
    </div>
	</BrowserRouter>),document.getElementById('root'));
 