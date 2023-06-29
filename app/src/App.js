import logo from './logo.svg';
import React, { useEffect, useState } from 'react';
import './App.css';


const App = () => {

  const [employers, setEmployers] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('/employers')
        .then(response => response.json())
        .then(data => {
          setEmployers(data);
          setLoading(false);
        })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Employer List</h2>
            {employers.map(emp=> emp.email)}
          </div>
        </header>
      </div>
  );
}

export default App;
