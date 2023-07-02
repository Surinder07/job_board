import logo from './logo.svg';
import React, {Component} from 'react';
import './App.css';
import {List} from "reactstrap";

/*
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
}*/

class App extends Component {
    state = {
        clients: []
    };

    async componentDidMount() {
        const response = await fetch('/employers');
        const body = await response.json();
        this.setState({clients: body});
/*        client({method: 'GET', path: '/employers'}).done(response => {
            this.setState({employees: response.entity.employees});
        });*/
    }

    render() {
        const {clients} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo" />
                    <div className="App-intro">
                        <h2>Employees</h2>
                       {clients.map(client =>
                            <div key={client.id}>
                                {client.password} ({client.email})
                            </div>
                        )}

                    </div>
                </header>
            </div>
        );
    }
}


export default App;
