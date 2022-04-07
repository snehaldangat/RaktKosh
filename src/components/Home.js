import AliceCarousel from 'react-alice-carousel';

import "react-alice-carousel/lib/alice-carousel.css";
import React, { Component } from 'react'
import Container from 'react-bootstrap/Container'
import "./css/image.css";
import "./css/home.css";
import "./css/table.css";

import img2 from"../images/blood.PNG";
import HomeTable from './HomeTable';

import blood from "../images/blood.PNG";
import image1 from "../images/image1.jpg";
import image2 from "../images/image2.jpg";

export class Home extends Component {
    fun=()=> {
        console.log("fun called");
        
    }
    
    
  render() {
   
    const bStyle={
      color: "#961e1b", fontWeight: "bold" ,textAlign:"center"
    }
    return (
      
     
      <>
      <AliceCarousel autoPlay autoPlayInterval={"1000"} >
      <p><img src="http://www.student.chula.ac.th/~60370416/images/banner.jpg" className="sliderimg" /></p>
      <p><img src="https://indiancc.mygov.in/wp-content/uploads/2021/08/mygov-9999999992095197695-1024x390.jpg" className="sliderimg" /></p>
      <p><img src="https://gumlet.assettype.com/thebridgechronicle%2Fimport%2Fs3fs-public%2Fnews-story%2Fcover-images%2F3Blood_0.jpg?auto=format%2Ccompress&fit=max&format=webp&w=768&dpr=1.0" className="sliderimg" /></p>

      </AliceCarousel>
      <HomeTable /> 
      



      <Container style={{backgroundColor:"lightgrey"}} className="info1">
        <h1 style={{color:" #961e1b"}}>TYPES OF DONATION</h1>
        
        <p className='para' style={{marginTop:"40px"}}>
        The human body contains five liters of blood, 
        which is made of several useful components i.e. Whole blood, Platelet, and Plasma.
        </p>
        <p className='para'>Each type of component has several medical uses and can be used for different medical treatments. your blood donation determines the best donation for you to make.</p>
        <p className='para'>For plasma and platelet donation you must have donated whole blood in past two years.</p>

        <hr
        style={{
            color:"black",
            height: 5
        }}
    />

        <p style={{color:"#961e1b",marginLeft:"70px",textAlign:"left"}}>Whole Blood</p>
        <hr
        style={{
            color:"black",
            height: 5
        }}
    />
    
        <div className="row tabInfo" id="wholeblood">
		    <div className="col-md-4 ">
		
			<h3>What is it?</h3>
			
			<p className='para'>
			Blood Collected straight from the donor after its donation usually separated into red blood cells, platelets, and plasma.</p>
			
			<h3>Who can donate?</h3>
			
			<p className='para'>You need to be 18-65 years old, weigh 45kg or more and be fit and healthy.</p>
		

		</div>
		<div className="col-md-4 infoContent">
		<h3>User For?</h3>
			
			<p className='para'>
			 Stomach disease, kidney disease, childbirth, operations, blood loss, trauma, cancer, blood diseases, haemophilia, anemia, heart disease.</p>
			
			<h3>Lasts For?</h3>
			
			<p className='para'>Red cells can be stored for 42 days.</p>
		
		</div>
		<div className="col-md-4 ">
		<h3>How long does it take?</h3>
			
			<p className='para'>
			15 minutes to donate.</p>
			
			<h3>How often can I donate?</h3>
			
			<p className='para'>Every 12 weeks</p>
		
		</div>
		</div>
   </Container>
    
   
   
         </>
      
    )
  }
}



export default Home