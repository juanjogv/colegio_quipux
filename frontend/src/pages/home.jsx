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
      Home
      <button
        onClick={() => {
          auth.logout(() => navigate("/"));
        }}
      >
        Sign out
      </button>
    </div>
  );
};

export default Home;
