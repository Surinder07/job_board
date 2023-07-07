
import React from 'react';
import { BrowserRouter as Router , Route, Switch } from 'react-router-dom';
import './App.css';
import ListEmployerCmp from './components/ListEmployerCmp';
import FooterCmp from './components/FooterCmp';
import HeaderCmp from './components/HeaderCmp';


function App() {
  return (

    <div>
      <Router>
        <div >
          <HeaderCmp />
          <div className='container'>
          
            <Switch> 
              <Route   exactpath='/' Component={ListEmployerCmp}><ListEmployerCmp /></Route>
              <Route  exact path='/employers' Component={ListEmployerCmp} ><ListEmployerCmp /></Route>
              {/* <ListEmployerCmp /> */}
            </Switch>
          </div>
          <FooterCmp />
        </div>
      </Router>
    </div>

  )
}


export default App;
