import { useContext } from "react";
import { useNavigate } from "react-router-dom";

import { AuthContext } from "../components/auth/authProvider";

const useAuth = () => {
  return useContext(AuthContext);
};

const Home = () => {
  let auth = useAuth();
  let navigate = useNavigate();
  return (
    <div>
      <h1>Home</h1>
      <div>
        <button
          onClick={() => {
            auth.signout(() => navigate("/"));
          }}
        >
          Sign out
        </button>
      </div>
    </div>
  );
};

export default Home;
