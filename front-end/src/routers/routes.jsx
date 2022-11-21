import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Login from "../Login/index";
import Cadastro from "../Cadastro/index";
import Index from "../Index/index";
import TelaUsuario from "../TelaUsuario";

export default function appRouter() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="/login" element={<Login />} />
        <Route path="/cadastro" element={<Cadastro />} />
        <Route path="/tela-usuario" element={<TelaUsuario />} />
      </Routes>
    </Router>
  );
}
