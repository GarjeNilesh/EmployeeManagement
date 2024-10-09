import React, { useState } from 'react';
import EmployeeService from '../service/EmployeeService';

function Register() {

    const [employee,setEmployee]=useState({
        username:'',
        email:'',
        password:'',
    });

    const [msg,setMessage]=useState();
    
    const handleChange=(e)=>{
        const{name,value}=e.target;
        setEmployee({
            ...employee,[name]:value,
        })
    }
    
    const handleSubmit=(e)=>{
      e.preventDefault();
      
      EmployeeService.saveEmployee(employee)
      .then(response=>{
        console.log("Employee Saved ",response.data);
        setMessage("Inserted Data Successfully ")
      })
      .catch(error=>{
         console.log("Something Wrong ",error);
      });
    
    };
    

  return (
    <div className="container">
      <h2>Register Page</h2>
      {msg && <div className="alert alert-success">{msg}</div>}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
      
          <label htmlFor="username" className="form-label">Username</label>
          <input type="text" className="form-control" name="username" id="username" onChange={handleChange} />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input type="email" className="form-control" name="email" id="email" onChange={handleChange}  />
        </div>
        <div className="mb-3">
          <label htmlFor="password" className="form-label">Password</label>
          <input type="password" className="form-control" name="password" id="password" onChange={handleChange} />
        </div>
        <button type="submit" className="btn btn-primary">Register</button>
      </form>
    </div>
  );
}

export default Register;
