import { createContext, useContext } from "react";
import { useNavigate, useLocation, Navigate } from "react-router-dom";
import { useCookies } from "react-cookie";
import axios from "axios";

let AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [cookies, setCookie, removeCookie] = useCookies(["userData"]);
  const user = cookies.userData;

  let signin = (user, callback) => {
    axios
      .post("/api/auth/signin", user)
      .then((res) => {
        setCookie("userData", res.data, { path: "/" });
        callback();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  let signout = (callback) => {
    removeCookie("userData");
    callback();
  };

  let value = { user, signin, signout };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

const useAuth = () => {
  return useContext(AuthContext);
};

const AuthChecker = ({ children }) => {
  let auth = useAuth();
  let location = useLocation();

  if (auth.user) {
    return <Navigate to="/" state={{ from: location }} replace />;
  }

  return children;
};

const RequireAuth = ({ children }) => {
  let auth = useAuth();
  let location = useLocation();

  if (!auth.user) {
    return <Navigate to="/signin" state={{ from: location }} replace />;
  }

  return children;
};

const AuthStatus = () => {
  let auth = useAuth();
  let navigate = useNavigate();

  if (!auth.user) {
    return <p>You are not logged in.</p>;
  }

  return (
    <p>
      Welcome {auth.user}!{" "}
      <button
        onClick={() => {
          auth.signout(() => navigate("/"));
        }}
      >
        Sign out
      </button>
    </p>
  );
};

export { AuthContext, AuthProvider, AuthChecker, RequireAuth, AuthStatus };
