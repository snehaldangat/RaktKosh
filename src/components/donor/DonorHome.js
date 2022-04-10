import React, { Component } from "react";
import axios from "axios";
import { Form, Button, Table } from "react-bootstrap";
import "../css/common.css";
import commonService from "../../service/common.service";
import { Link, Navigate } from "react-router-dom";

class DonorHome extends Component {
    constructor(props) {
        super(props);

        this.state = {
            bankdata: [],
            loginUserEmail:'',
            loginUserRole:'',
            redirect:'',
            data:'',
            bank:'',
            city:'',
            apositive:sessionStorage.getItem("apositive"),
        };
       // this.stateHandler = this.stateHandler.bind(this);
    }
     render(){
        const {data,bank,city}=this.state;
        //const {email} =this.state.data.bank;
        console.log(city);
        if (this.state.redirect) {
            return  <Navigate to={this.state.redirect} />
          }  
        return (
            <div>
                <div className="container bg-dark text-white text-center mt-4 col-12">
                    <div className="row">
                        <div className="col "></div>
                        <div className="col-10 m-3">
                            <h1>Welcome Donor</h1>
                        </div>
                        <div className="col "></div>
                    </div>
                    <div className="row">
                        <Table striped bordered hover variant="dark" className="mb-3">
                            <thead>
                                <tr>
                                    
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Birth Date</th>
                                    <th>Gender</th>
                                    <th>Mobile</th>
                                   
                                </tr>
                            </thead>
                             
                            
                            
                             <tbody>
                                <tr>
                                    <td>{bank.bankName}</td>
                                    <td>{bank.parentHospital}</td>
                                    <td>{bank.shortName}</td>
                                    <td>{bank.category}</td>
                                    <td>{bank.licence}</td>
                                    <td>{city.name}</td>
                                    <td>{bank.address}</td>
                                </tr>
                            </tbody> 
                        </Table>
                    </div>
                    
                    
                </div>
                
                <div class="col-md-12 text-center">
                <Link to="/">
                <Button className="m-4"variant="primary" type="submit">
                        Logout
                    </Button>
                    </Link>
                    </div>
            </div>
        );
       }
    
}

export default DonorHome;
