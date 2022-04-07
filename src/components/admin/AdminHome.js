import React, { Component } from "react";
import axios from "axios";
import { Form, Button, Table, Toast  } from "react-bootstrap";
import "../css/common.css";
import bankService from "../../service/bankService";
import adminService from "../../service/adminService";
import { PaginationTable } from "./table/PaginationTable";
//import {selectedArray} from './table/columns/selectedArray'
class AdminHome extends Component {
    constructor(props) {
        super(props);

        this.state = {
            statesdata: [],
            districtsdata: [],
            selectedArray:[]
        };
        this.requestacceptHandler = this.requestacceptHandler.bind(this);
    }
    

    componentDidMount() {
        
                bankService.getAllPendingReqBank()
                .then((response) => {
                    console.log("componentDidMount");
                    console.log(response.data);
                    this.setState({ statesdata: response.data });
                    //console.log(this.state.statesdata);
                })
                .catch((error) => {
                    console.log(error);
                });
        //}
        console.log("out");
        const selectedArray = new Array()
        
    }
    requestacceptHandler = (event) => {
    
        const {selectedArray} = this.state;
        console.log(event.target.value);
        if(selectedArray.length>0){
        console.log(selectedArray);
        const myJSON=JSON.stringify(selectedArray)
        console.log(myJSON);
        if(event.target.value==="accept"){
            console.log("accept fun");
            adminService.acceptBankRequest(selectedArray) 
          .then(response => {
            console.log("componentDidMount");
            console.log(response.data);
            //this.setState({ districtsdata: response.data })
            //console.log(this.state.districtsdata);

          })
          .catch(error => {
            console.log(error);
          })

        }
        else if(event.target.value==="reject"){
            console.log("reject fun");
            adminService.rejectBankRequest(selectedArray) 
            .then(response => {
              console.log("componentDidMount");
              console.log(response.data);
            })
            // .catch(error => {
            //   console.log(error);
            // })
        }
        }
        alert("button was clicked");
        
        
          event.preventDefault();
    }

    // stateHandler(e) {
    //     console.log(e.target.value);
    //     if (e.target.value >= 0) {
    //         this.setState({
    //             districtsdata: this.state.statesdata[e.target.value - 1].districts,
    //         });
    //         console.log(this.state.districtsdata);
    //     } else {
    //         this.setState({ districtsdata: [] });
    //     }
    // }

    render() {
        // const { statesdata, districtsdata } = this.state;
        // console.log(districtsdata);
        // let statesList =
        //     statesdata.length > 0 &&
        //     statesdata.map((item, i) => {
        //         return (
        //             <option key={i} value={item.id}>
        //                 {item.name}
        //             </option>
        //         );
        //     }, this);

        // let districtsList =
        //     districtsdata.length > 0 &&
        //     districtsdata.map((item, i) => {
        //         return (
        //             <option key={i} value={item.id}>
        //                 {item.name}
        //             </option>
        //         );
        //     }, this);
        const {statesdata, selectedArray}=this.state;
        const COLUMNS=[
            {
                Header:' ',
                Footer:' ',
                accessor:'',
                Cell: ({ cell }) => {
                    return <input name="selector[]" id="ad_Checkbox1" className="ads_Checkbox" type="checkbox" 
                    onClick={(e)=>{
                        console.log(e.target.checked);
                        console.log(cell.row.allCells[1].value)
                        if(e.target.checked)
                           selectedArray.push(cell.row.allCells[1].value)
                        else{
                            var myIndex = selectedArray.indexOf(cell.row.allCells[1].value);
                            console.log(myIndex);
                            if (myIndex !== -1) {
                                selectedArray.splice(myIndex, 1);
                            }
                            console.log(selectedArray)

                        }
                        
                         
                        
                    }} />
                }
            },
            {
                Header:'Email',
                Footer:'Email',
                accessor:'email'
            },
            {
                Header:'Blood Bank Name',
                Footer:'Blood Bank Name',
                accessor:'bankName'
            },
            {
                Header:'Parent Hospital',
                Footer:'Parent Hospital',
                accessor:'parentHospital'
            },
            {
                Header:'Short Name',
                Footer:'Short Name',
                accessor:'shortName'
            },
            {
                Header:'Category',
                Footer:'Category',
                accessor:'category'
            },
            {
                Header:'Licence',
                Footer:'Licence',
                accessor:'licence',
                // Cell: ({ cell }) => (
                //     <button value={cell.row.values.name} onClick={(e)=>{console.log(cell.row.allCells[0].value);}}>
                //       {cell.row.values.name}
                //     </button>
                //   )
            },
            {
                Header:'Person Name',
                Footer:'Person Name',
                accessor:'personName'
            },
            {
                Header:'Contact',
                Footer:'Contact',
                accessor:'contact'
            },
            {
                Header:'City',
                Footer:'City',
                accessor:'city',
                Cell: ({ cell }) => {
                    console.log(cell.value.district.name)
                    return cell.value.name//<div> {cell.value.name}, {cell.value.district.name}, {cell.value.district.state.name}</div>
                }   
            },
            {
                Header:'Component Facility',
                Footer:'Component Facility',
                accessor:'facility'
            }
            // {
            //     Header:'District',
            //     Footer:'District',
            //     accessor:'city.district',
            //     Cell: ({ cell }) => {
            //         console.log(cell.value.name)
            //         //return cell.value.name
            //     }   
            // }
        
        
                ]

                


        return (
            
            
            <div className=" bg-dark text-white text-center ">
                <div className="container bg-dark text-white text-center mt-4">
                    <Form > 
                        <div className="row">
                            <div className="col "></div>
                            <div className="col-10 m-3">
                                <h1>Welcome Admin</h1>
                            </div>
                            <div className="col "></div>
                        </div>
                         <div className="row">
                            <div className="col "></div>
                            <div className="col-4 m-5">
                                <Table striped bordered hover variant="dark" className="mb-3">
                                    <thead>
                                        <tr>
                                            
                                            <th colSpan={2} className="col-4">Action on BloodBank Requests</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            
                                            <td><Button variant="btn btn-outline-success"
                                            type="submit" value="accept"
                                            onClick={this.requestacceptHandler}
                                            >
                                                Accept{" "}
                                            </Button></td>
                                            <td><Button variant="btn btn-outline-danger" type="submit"
                                            value="reject">
                                                Reject{" "}
                                            </Button></td>
                                        </tr>
                                    </tbody>
                                </Table>
                            </div>
                            <div className="col "></div>
                        </div> 
                    </Form>
                    
                </div>
                <div>
                    <PaginationTable MOCK_DATA={statesdata} COLUMNS={COLUMNS}/>
                </div>
            </div>
        );
    }
}

export default AdminHome;
