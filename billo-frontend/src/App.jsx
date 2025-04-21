import React from "react";
import Navbar from "./components/Navbar";
import { Router, Routes, Route } from "react-router-dom";
import Dashboard from "./pages/Dashboard/Dashboard";
import Explore from "./pages/Explore/Explore";
import ManageCategories from "./pages/Manage-Categories/ManageCategories";
import ManageItems from "./pages/Manage-Items/ManageItems";
import ManageUsers from "./pages/Manage-Users/ManageUsers";
const App = () => {
  return (
    <>
      <Navbar />
        <Routes>
          <Route path="/dashboard" element={<Dashboard />}></Route>
          <Route path="/explore" element={<Explore />}></Route>
          <Route path="/category" element={<ManageCategories />}></Route>
          <Route path="/item" element={<ManageItems />}></Route>
          <Route path="/user" element={<ManageUsers />}></Route>
        </Routes>
    </>
  );
};

export default App;
