import { createContext, useContext } from "react";
import { useNavigate, useLocation, Navigate } from "react-router-dom";

import { useCookies } from "react-cookie";
import axios from "axios";

let AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [cookies, setCookie, removeCookie] = useCookies(["userData"]);
  const user = cookies.userData;

  let login = (user, callback) => {
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

  let logout = (callback) => {
    removeCookie("userData");
    callback();
  };

  let value = { user, login, logout };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

const useAuth = () => {
  return useContext(AuthContext);
};

const RequireAuth = ({ children }) => {
  let auth = useAuth();
  let location = useLocation();

  if (!auth.user) {
    // Redirect them to the /login page, but save the current location they were
    // trying to go to when they were redirected. This allows us to send them
    // along to that page after they login, which is a nicer user experience
    // than dropping them off on the home page.
    return <Navigate to="/login" state={{ from: location }} replace />;
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
          auth.logout(() => navigate("/"));
        }}
      >
        Sign out
      </button>
    </p>
  );
};

export { AuthProvider, AuthContext, RequireAuth, AuthStatus };
