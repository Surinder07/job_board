import React, { Component } from 'react';
import EmployerService from '../services/EmployerService';


class ListEmployerCmp extends Component {
    constructor(props){
        super(props)

        this.state={
            employers :[] 
        }
    }
    componentDidMount(){
        EmployerService.getEmployers().then((res)=>{
                this.setState({employers: res.data});
            });
    }
    render() {
        return (
            <div>
                <h2 className='text-center'>Employers List</h2>
                <div className='row'>
                    <table className='table table-striped table-bordered table-hover'>

                        <thead>
                            <tr>
                                <th> Company Name</th>
                                <th> Company Email</th>
                                <th>Acttions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.employers.map(
                                    employer =>
                                    <tr key={employer.id}>
                                        <td>{employer.companyName}</td>
                                        <td>{employer.email}</td>
            

                                    </tr>
                                )
                            }

                        </tbody>

                    </table>

                </div>


                
            </div>
        );
    }
}

export default ListEmployerCmp;