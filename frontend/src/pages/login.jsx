import React, {useState} from "react";

import '../style/login.css';


const Login = () => {
  
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (event)=>{
    event.preventDefault();
    console.log("Hola mundo")
  }

  return(
    <>
      <form onSubmit={handleSubmit}>
                <div className="container">
                    <input
                        type="text"
                        placeholder="Enter Username"
                        name="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)} required />
                    <input
                        type="password"
                        placeholder="Enter Password"
                        name="psw"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)} required />
                    <button type="submit">Login</button>
                </div>
        </form>
    </>
  );
};

export default Login;
