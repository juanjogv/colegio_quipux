import React, { useState } from "react";

import '../style/login.css';

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("Hola mundo");
  };

  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-xl-6 col-lg-6 col-md-12"></div>
        <div className="col-xl-6 col-lg-6 col-md-12">
          <form>
            <div class="mb-3">
              <input type="text" class="form-control" id="exampleInputEmail1" placeholder="User" aria-describedby="emailHelp" />
            </div>
            <div class="mb-3">
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
            </div>
            <button type="submit" className="btn btn-primary boton">
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
