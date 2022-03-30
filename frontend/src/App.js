import * as React from "react";
import Signin from "./pages/signin";
import Home from "./pages/home";
import { AuthProvider, AuthChecker, RequireAuth } from "./components/auth/authProvider";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route
          path="/signin"
          element={
            <AuthChecker>
              <Signin />
            </AuthChecker>
          }
        />
        <Route
          path="/"
          element={
            <RequireAuth>
              <Home />
            </RequireAuth>
          }
        />
      </Routes>
    </AuthProvider>
  );
}

export default App;
