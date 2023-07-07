import axios from "axios";
import { Component } from "react";



class EmployerService extends Component{
 
    getEmployers(){
        return axios.get("http://localhost:2020/employers");
    }

}


export default new EmployerService() ;