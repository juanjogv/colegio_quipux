import { useState, useContext } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { AuthContext } from "../components/auth/authProvider";

import "./style/login.css";

function useAuth() {
  return useContext(AuthContext);
}

const Login = () => {
  const [user, setUser] = useState({ username: "", password: "" });

  let navigate = useNavigate();
  let location = useLocation();
  let auth = useAuth();

  let from = location.state?.from?.pathname || "/";

  const handleSubmit = (event) => {
    event.preventDefault();
    auth.login(user, () => {
      // Send them back to the page they tried to visit when they were
      // redirected to the login page. Use { replace: true } so we don't create
      // another entry in the history stack for the login page.  This means that
      // when they get to the protected page and click the back button, they
      // won't end up back on the login page, which is also really nice for the
      // user experience.
      navigate(from, { replace: true });
    });
  };

  return (
    <div className="container-fluid">
      <div className="row align-items-center p-5 vh-100">
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-12"></div>
        <div className="col-xl-6 col-lg-6 col-md-6 col-sm-12">
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <input
                name="username"
                type="text"
                className="form-control"
                id="InputEmail"
                placeholder="Usuario"
                value={user.username}
                onChange={(e) => setUser({ ...user, username: e.target.value })}
              />
            </div>
            <div className="mb-3">
              <input
                mame="password"
                type="password"
                className="form-control"
                id="InputPassword"
                placeholder="Contraseña"
                value={user.password}
                onChange={(e) => setUser({ ...user, password: e.target.value })}
              />
            </div>
            <button type="submit" className="btn btn-primary boton">
              Iniciar sesión
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;
