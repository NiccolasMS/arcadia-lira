import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "../Login/index";
import Cadastro from "../Cadastro/index";
import Index from "../Index/index";
import Morador from "../Morador/index";
import Porteiro from "../Porteiro/index";

export default function appRouter() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="/login" element={<Login />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/morador" element={<Morador />} />
        <Route path="/porteiro" element={<Porteiro />} />
      </Routes>
    </Router>
  );
}
