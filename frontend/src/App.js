import * as React from "react";
import Login from "./pages/login";
import Home from "./pages/home";
import { AuthProvider, RequireAuth } from "./components/auth/authProvider";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <AuthProvider>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route
          path="/home"
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
